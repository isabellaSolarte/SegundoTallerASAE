package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.gateways;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.DocentesRepository;

public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort
{

    private final DocentesRepository objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocentesRepository objDocenteRepository, ModelMapper docModelMapper)
    {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docModelMapper;
    }

    @Override
    public boolean existeUsuarioPorCodigo(Integer codigo) {
        return this.objDocenteRepository.existeUsuarioPorCodigo(codigo) == 1;
    }

    @Override
    public Docente guardar(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public List<Docente> listar() {
        Iterable<DocenteEntity> lista = this.objDocenteRepository.findAll();
        List<Docente> listaObtenida = this.docenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }
    
}
