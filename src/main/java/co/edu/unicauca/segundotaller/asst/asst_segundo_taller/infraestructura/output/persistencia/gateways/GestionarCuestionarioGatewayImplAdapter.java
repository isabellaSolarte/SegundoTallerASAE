package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.gateways;

import java.util.List;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.CuestionarioEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.PreguntaEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.TipoPreguntaEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.CuestionariosRepository;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.TipoPreguntasRepository;

@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort 
{
    private final CuestionariosRepository objCuestionarioRepository;
    private final ModelMapper cuestionarioModelMapper;
    private final TipoPreguntasRepository tipoPreguntaRepository;
    public GestionarCuestionarioGatewayImplAdapter(CuestionariosRepository objCuestionarioRepository, ModelMapper cuestionarioModelMapper,TipoPreguntasRepository tipoPreguntaRepository)
    {
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
        this.tipoPreguntaRepository = tipoPreguntaRepository;
    }

	@Override
	public boolean existeCuestionarioPorTitulo(String tituloCuestionario) {
		return this.objCuestionarioRepository.existeCuestionarioPorTitulo(tituloCuestionario) == 1;
	}

	@Override
	public Cuestionario guardar(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        //Asignar las preguntas al cuestionario
        for (PreguntaEntity pregunta : objCuestionarioEntity.getPreguntas()) {
            Optional<TipoPreguntaEntity> tipoPregunta = tipoPreguntaRepository.findById(pregunta.getObjTipoPregunta().getIdtippregunta());
            System.out.println("Tipo de pregunta: "+tipoPregunta.get().getNombre());
            pregunta.setObjTipoPregunta(tipoPregunta.get());
            pregunta.setObjCuestionario(objCuestionarioEntity);
            System.out.println("Pregunta: "+pregunta.getEnunciado());
            tipoPregunta.get().getListaPregunta().add(pregunta);
        }
        
        CuestionarioEntity objCuestionarioEntityRegistrado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        System.out.println("Cuestionario guardado: "+objCuestionarioEntityRegistrado.getTitulo());
        Cuestionario objCuestionarioRespuesta = this.cuestionarioModelMapper.map(objCuestionarioEntityRegistrado, Cuestionario.class);
        return objCuestionarioRespuesta;
    }
		

	@Override
	public List<Cuestionario> listar() {
		Iterable<CuestionarioEntity> lista = this.objCuestionarioRepository.findAll(); //TODO-cambiar
        List<Cuestionario> listaObtenida = this.cuestionarioModelMapper.map(lista, new org.modelmapper.TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
	}
    
}
