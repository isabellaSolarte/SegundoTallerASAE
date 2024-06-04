package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.TipoPreguntaDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.mappers.CuestionarioMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CuestionarioRestController {
    private final GestionarCuestionarioCUIntPort objGestionarCuestionarioCUInt;
    private final CuestionarioMapperInfraestructuraDominio objMapeador;
    
    
    @PostMapping("/cuestionario")
    public ResponseEntity<?> crear(@Valid @RequestBody CuestionarioDTOPeticion objCuestionario, BindingResult result) {
        Cuestionario objCuestionarioCrear = objMapeador.mappearDePeticionACuestionario(objCuestionario);
        Map<String, Object> response = new HashMap<>();
        CuestionarioDTORespuesta objCuestionarioCreado = null;
        response = this.catchErrors(result);
        if(response.size()!=0){
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            objCuestionarioCreado = objMapeador.mappearDeCuestionarioARespuesta(objGestionarCuestionarioCUInt.crear(objCuestionarioCrear));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<CuestionarioDTORespuesta>(
            objCuestionarioCreado, HttpStatus.CREATED
        );
    }
    @GetMapping("/cuestionarios")
    public ResponseEntity<List<CuestionarioDTORespuesta>> listar() {
        ResponseEntity<List<CuestionarioDTORespuesta>> objRespuesta = new ResponseEntity<List<CuestionarioDTORespuesta>>(
                objMapeador.mappearDeCuestionariosARespuesta(this.objGestionarCuestionarioCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/tipoPreguntas")
    public ResponseEntity<List<TipoPreguntaDTORespuesta>> listarTipoPregunta() {
        ResponseEntity<List<TipoPreguntaDTORespuesta>> objRespuesta = new ResponseEntity<List<TipoPreguntaDTORespuesta>>(
                objMapeador.mappearDeTipoPreguntaARespuesta(this.objGestionarCuestionarioCUInt.listaTipoPreguntas()),
                HttpStatus.OK);
        return objRespuesta;
    }
private Map<String, Object> catchErrors(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("El campo '" + error.getField() + "‘ " + error.getDefaultMessage());
            }
            response.put("errors", listaErrores);
        }
        return response;

    }
   

    
}
