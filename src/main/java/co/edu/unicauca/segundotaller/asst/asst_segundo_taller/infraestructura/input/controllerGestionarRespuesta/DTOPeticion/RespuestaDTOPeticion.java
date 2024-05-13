package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class RespuestaDTOPeticion {
    private int idrespuesta;

    @NotNull(message = "{respuesta.descripcion.emply}")
    @Size(min = 3, max = 400, message = "{respuesta.descripcion.size}")
    private String descripcion;

    private int idPregunta;
    private int idDocente;

}
