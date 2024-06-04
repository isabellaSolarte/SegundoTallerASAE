package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta.DepartamentoDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestasDocenteDTORespuesta;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class DocenteRestController 
{
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/docente")
    public ResponseEntity<?> create(@Valid @RequestBody DocenteDTOPeticion objDocente, BindingResult result) {
        
        Docente objDocenteCrear = objMapeador.mappearDePeticionADocente(objDocente);
        Map<String, Object> response = new HashMap<>();
        DocenteDTORespuesta objDocenteCreado = null;
        response = this.catchErrors(result);
        if(response.size()!=0){
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            objDocenteCreado = objMapeador.mappearDeDocenteARespuesta(objGestionarDocenteCUInt.crear(objDocenteCrear));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<DocenteDTORespuesta>(
            objDocenteCreado,
            HttpStatus.CREATED);
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
                objMapeador.mappearDeDocentesARespuesta(this.objGestionarDocenteCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
    
    @GetMapping("/docentes/deptos")
    public ResponseEntity<List<DepartamentoDTORespuesta>> listarDeptos() {
        ResponseEntity<List<DepartamentoDTORespuesta>> objRespuesta = new ResponseEntity<List<DepartamentoDTORespuesta>>(
                objMapeador.mappearDeDeptoARespuesta(this.objGestionarDocenteCUInt.listarDepartamentos()),
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
