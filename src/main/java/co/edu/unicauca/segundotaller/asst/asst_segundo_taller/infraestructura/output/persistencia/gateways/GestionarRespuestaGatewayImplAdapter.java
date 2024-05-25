package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.gateways;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.CuestionarioEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.DocenteEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.PreguntaEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.RespuestaEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.CuestionariosRepository;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.DocentesRepository;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.PreguntasRepository;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios.RespuestasRepository;

@Service
public class GestionarRespuestaGatewayImplAdapter implements GestionarRespuestaGatewayIntPort
{
    private final PreguntasRepository objPreguntasRepository;
    private final CuestionariosRepository objCuestionariosRepository;
    private final DocentesRepository objDocentesRepository;
    private final RespuestasRepository objRespuestasRepository;
    private final ModelMapper respuestaModelMapper;

    public GestionarRespuestaGatewayImplAdapter(PreguntasRepository objPreguntasRepository, CuestionariosRepository objCuestionariosRepository,
                                                DocentesRepository objDocentesRepository, RespuestasRepository objRespuestasRepository, ModelMapper respuestaModelMapper)
    {
        this.objCuestionariosRepository = objCuestionariosRepository;
        this.objDocentesRepository = objDocentesRepository;
        this.objPreguntasRepository = objPreguntasRepository;
        this.objRespuestasRepository = objRespuestasRepository;
        this.respuestaModelMapper = respuestaModelMapper;
    }

    @Override
    public boolean existeRespuestaCuestionario(int codigo) 
    {
        return this.objRespuestasRepository.existeRespuestaCodigo(codigo) == 1;
    }

    @Override
    public Pregunta guardar(Pregunta pregunta, Cuestionario cuestionario, Docente docente) 
    {
        Optional<PreguntaEntity> objPreguntaEntity = this.objPreguntasRepository.findById(pregunta.getIdpregunta());
        Optional<DocenteEntity> objDocenteEntity = this.objDocentesRepository.findById(docente.getIdPersona());
        List<RespuestaEntity> listaAux = objDocenteEntity.get().getRespuestas();
        for(Respuesta respuesta:pregunta.getRespuestaEntities()){
            RespuestaEntity respuestaEntity=this.respuestaModelMapper.map(respuesta,RespuestaEntity.class);
            respuestaEntity.setObjPreguntaEntity(objPreguntaEntity.get());
            respuestaEntity.setObjDocente(objDocenteEntity.get());
            listaAux.add(respuestaEntity);
        }

        objDocenteEntity.get().setRespuestas(listaAux);
        this.objRespuestasRepository.saveAll(listaAux);
        return this.respuestaModelMapper.map(objPreguntaEntity.get(),Pregunta.class);
    }

    @Override
    public boolean validarDocenteCuestionario(Docente docente, Cuestionario cuestionario) 
    {   
        Optional<DocenteEntity> docenteEntity=this.objDocentesRepository.findById(docente.getIdPersona());
        Optional<CuestionarioEntity> cuestionarioEntity=this.objCuestionariosRepository.findById(cuestionario.getIdCuestionario());
        List<RespuestaEntity> lista=docenteEntity.get().getRespuestas();
        for (RespuestaEntity respuestaEntity : lista) 
        {
            if(respuestaEntity.getObjPreguntaEntity().getObjCuestionarioEntity().getIdCuestionario()==cuestionarioEntity.get().getIdCuestionario())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Docente obtenerDocenteCuestionario(int codigo) 
    {
        Optional<DocenteEntity> docenteEntity=this.objDocentesRepository.findById(codigo);
        return this.respuestaModelMapper.map(docenteEntity.get(),Docente.class);
    }

    @Override
    public Docente buscarPorId(Integer id) {
        Optional<DocenteEntity> docenteEntity=this.objDocentesRepository.findById(id);
        return this.respuestaModelMapper.map(docenteEntity.get(),Docente.class);
    }

    @Override
    public List<Respuesta> buscarRespuestaPorIdDocente(Integer id) {
        Iterable<RespuestaEntity> respuestas = this.objRespuestasRepository.findByidDocente(id);
        List<Respuesta> listaObtenida = this.respuestaModelMapper.map(respuestas, new TypeToken<List<Respuesta>>() {
        }.getType());
        return listaObtenida;
    }
    
}
