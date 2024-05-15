package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.gateways;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Departamento;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.DepartamentoEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.TelefonoEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.TipoPreguntaEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.DepartamentosRepository;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.DocentesRepository;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.TelefonosRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort
{

    private final DocentesRepository objDocenteRepository;
    private final ModelMapper docenteModelMapper;
    private final DepartamentosRepository objDepartamentosRepository;

    public GestionarDocenteGatewayImplAdapter(DocentesRepository objDocenteRepository, ModelMapper docModelMapper, DepartamentosRepository objDepartamentosRepository)
    {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docModelMapper;
        this.objDepartamentosRepository = objDepartamentosRepository;
    }
  

    @Override
    public Docente guardar(Docente objDocente) 
    {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        TelefonoEntity telAux = new TelefonoEntity(
            objDocenteEntity.getObjTelefono().getIdtelefono(),
            objDocenteEntity.getObjTelefono().getTipotelefono(),
            objDocenteEntity.getObjTelefono().getNumero(),
            objDocenteEntity
        );
        objDocenteEntity.setObjTelefono(telAux);
        telAux.setObjDocente(objDocenteEntity);

        List<DepartamentoEntity> departamentosAñadir = new ArrayList<>();
        for(DepartamentoEntity dept: objDocenteEntity.getListaDepartamentos())
        {
            Optional<DepartamentoEntity> optionDept= objDepartamentosRepository.findById(dept.getIddepartamento());
            DepartamentoEntity dpEntity = optionDept.orElseThrow(() -> new EntityNotFoundException("TipoPregunta not found"));

            
            departamentosAñadir.add(dpEntity);
            
        }
        objDocenteEntity.setListaDepartamentos(departamentosAñadir);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public List<Docente> listar() 
    {
        Iterable<DocenteEntity> lista = this.objDocenteRepository.findAll();
        List<Docente> listaObtenida = this.docenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public boolean existeUsuarioPorId(Integer id) 
    {
        return this.objDocenteRepository.existeUsuarioPorId(id) == 1;
    }

    @Override
    public boolean existeUsuarioPorCodigo(String id)
    {
        return this.objDocenteRepository.existeUsuarioPorCodigo(id) == 1;
    }
    
}
