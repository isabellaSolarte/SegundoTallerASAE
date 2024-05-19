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
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.DepartamentosRepository;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.DocentesRepository;
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
        TelefonoEntity telefonoEntity = docenteModelMapper.map(objDocente.getObjTelefonoEntity(),TelefonoEntity.class);

        telefonoEntity.setObjDocente(objDocenteEntity);
        objDocenteEntity.setObjTelefono(telefonoEntity);
        List<DepartamentoEntity> departamentosAñadir = new ArrayList<>();
        for(Departamento dept: objDocente.getListaDepartamentos())
        {
            Optional<DepartamentoEntity> optionDept= objDepartamentosRepository.findById(dept.getIdDepartamento());
            DepartamentoEntity dpEntity = optionDept.orElseThrow(() -> new EntityNotFoundException("Dept not found"));            
            departamentosAñadir.add(dpEntity);
            
        }
        objDocenteEntity.setListaDepartamentos(departamentosAñadir);

        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        System.out.println("NO ENTROOOOO"+objDocenteEntityRegistrado.getListaDepartamentos().get(0).getDescripcion());

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

    @Override
    public Docente buscarPorId(Integer id) {
        DocenteEntity objDocenteEntity = this.objDocenteRepository.findById(id).get();
        Docente response = this.docenteModelMapper.map(objDocenteEntity, Docente.class);
        return response;
    }
    
}
