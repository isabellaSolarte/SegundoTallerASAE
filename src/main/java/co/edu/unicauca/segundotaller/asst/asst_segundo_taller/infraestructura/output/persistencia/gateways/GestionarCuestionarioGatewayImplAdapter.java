package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.gateways;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.TipoPregunta;
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
    public Cuestionario guardar(Cuestionario cuestionario) {
        CuestionarioEntity objCuestionarioaEntity=this.cuestionarioModelMapper.map(cuestionario, CuestionarioEntity.class);
        List<PreguntaEntity> lista=new ArrayList<>();
        for(PreguntaEntity preguntas:objCuestionarioaEntity.getPreguntaEntities()){
            Optional<TipoPreguntaEntity> tipoPregunta=tipoPreguntaRepository.findById(preguntas.getObjTipoPreguntaEntity().getIdtipPregunta());
            preguntas.setObjTipoPreguntaEntity(tipoPregunta.get());
            List<PreguntaEntity> existingPreguntas = tipoPregunta.get().getPreguntaEntity();
            existingPreguntas.add(preguntas);
            tipoPregunta.get().setPreguntaEntity(existingPreguntas);
            preguntas.setObjCuestionarioEntity(objCuestionarioaEntity);
            lista.add(preguntas);
        }
        objCuestionarioaEntity.setPreguntaEntities(lista);
        CuestionarioEntity objCuestionarioEntityRegistrado=this.objCuestionarioRepository.save(objCuestionarioaEntity);
        return this.cuestionarioModelMapper.map(objCuestionarioEntityRegistrado, Cuestionario.class);
        //return cuestionario;
    }

		

	@Override
	public List<Cuestionario> listar() {
		Iterable<CuestionarioEntity> lista = this.objCuestionarioRepository.findAllByOrderByTituloAsc(); 
        List<Cuestionario> listaObtenida = this.cuestionarioModelMapper.map(lista, new org.modelmapper.TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
	}

    @Override
    public List<TipoPregunta> listaTipoPreguntas() {
        
        Iterable<TipoPreguntaEntity> lista = this.tipoPreguntaRepository.findAll(); 
        List<TipoPregunta> listaObtenida = this.cuestionarioModelMapper.map(lista, new org.modelmapper.TypeToken<List<TipoPregunta>>() {
        }.getType());
        return listaObtenida;
    }
    
}
