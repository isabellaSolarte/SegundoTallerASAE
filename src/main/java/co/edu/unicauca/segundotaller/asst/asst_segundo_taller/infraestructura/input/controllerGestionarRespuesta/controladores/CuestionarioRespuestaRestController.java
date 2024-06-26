package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.controladores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.PeticionCuestionarioResueltoDTO;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestasDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestasDocenteDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.mappers.RespuestaMapperInfraestructuraDominio;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CuestionarioRespuestaRestController 
{
    private final GestionarRespuestaCUIntPort objGestionarRespuestaCUInt;
    private final RespuestaMapperInfraestructuraDominio objMapeador;

    @PostMapping("/respuesta")
    public ResponseEntity<PreguntaDTORespuesta> crear(@RequestBody PeticionCuestionarioResueltoDTO objPeticionDTO) 
    {
        Pregunta objRespuesta = objMapeador.mappearDePeticionARespuesta(objPeticionDTO.getObjPregunta());
        Cuestionario objCuestionario = objMapeador.mappearDePeticionACuestionario(objPeticionDTO.getObjCuestionario());
        Docente objDocente = objMapeador.mappearDePeticionADocente(objPeticionDTO.getObjDocente());
        Pregunta objPregunta = objGestionarRespuestaCUInt.crear(objDocente,objCuestionario,objRespuesta);
        return new ResponseEntity<PreguntaDTORespuesta>(
            objMapeador.mappearDeRespuestaCARespuesta(objPregunta), HttpStatus.CREATED
        );
    }

    @GetMapping("/respuestas")
    public ResponseEntity<DocenteDTORespuesta> listar(@RequestParam int id){
        return new ResponseEntity<DocenteDTORespuesta>(
            objMapeador.mappearDeRespuestaCARespuesta(this.objGestionarRespuestaCUInt.listar(id)),
                HttpStatus.OK
        );
    }
    

    @GetMapping("/respuestasDocente/{id}")
    public ResponseEntity<RespuestasDocenteDTORespuesta> listarDocenteRespuestaPorId(@PathVariable Integer id) {
        RespuestasDocenteDTORespuesta objRespuestasDocenteDTORespuesta = new RespuestasDocenteDTORespuesta();
        objRespuestasDocenteDTORespuesta.setObjDocente(objMapeador.mappearDeRespuestaCURespuesta(this.objGestionarRespuestaCUInt.buscarPorId(id)));

        List<Respuesta> respuestas = this.objGestionarRespuestaCUInt.buscarRespuestaPorIdDocente(id);
        List<RespuestasDTORespuesta> respuestasDTO = respuestas.stream()
        .map(respuesta -> objMapeador.mappearDeRespuestasCARespuestas(respuesta))
        .collect(Collectors.toList());
        objRespuestasDocenteDTORespuesta.setObjRespuesta(respuestasDTO);

        return new ResponseEntity<>(objRespuestasDocenteDTORespuesta, HttpStatus.OK);
    }

}
