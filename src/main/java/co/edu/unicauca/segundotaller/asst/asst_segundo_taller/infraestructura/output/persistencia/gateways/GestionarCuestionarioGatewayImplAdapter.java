package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.gateways;

import java.util.List;
import org.modelmapper.ModelMapper;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.CuestionarioEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.CuestionariosRepository;

public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort 
{
    private final CuestionariosRepository objCuestionarioRepository;
    private final ModelMapper cuestionarioModelMapper;

    public GestionarCuestionarioGatewayImplAdapter(CuestionariosRepository objCuestionarioRepository, ModelMapper cuestionarioModelMapper)
    {
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
    }

	@Override
	public boolean existeCuestionarioPorTitulo(String tituloCuestionario) {
		return this.objCuestionarioRepository.existeCuestionarioPorTitulo(tituloCuestionario) == 1;
	}

	@Override
	public Cuestionario guardar(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        CuestionarioEntity objCuestionarioEntityRegistrado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        Cuestionario objCuestionarioRespuesta = this.cuestionarioModelMapper.map(objCuestionarioEntityRegistrado, Cuestionario.class);
        return objCuestionarioRespuesta;
    }
		

	@Override
	public List<Cuestionario> listar() {
		Iterable<CuestionarioEntity> lista = this.objCuestionarioRepository.findAll();
        List<Cuestionario> listaObtenida = this.cuestionarioModelMapper.map(lista, new org.modelmapper.TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
	}
    
}
