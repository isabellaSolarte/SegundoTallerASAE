package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class DocenteRestController 
{
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/docente")
    public ResponseEntity<DocenteDTORespuesta> create(@RequestBody DocenteDTOPeticion objDocente) {

        Docente objDocenteCrear = objMapeador.mappearDePeticionADocente(objDocente);

        Docente objDocenteCreado = objGestionarDocenteCUInt.crear(objDocenteCrear);

        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mappearDeDocenteARespuesta(objDocenteCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
                objMapeador.mappearDeDocentesARespuesta(this.objGestionarDocenteCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
}
