package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion.PreguntaDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaDTOPeticion {
    private int idRespuesta;

    @NotNull(message = "{respuesta.descripcion.emply}")
    @Size(min = 3, max = 400, message = "{respuesta.descripcion.size}")
    private String descripcion;
    private DocenteDTOPeticion objUsuario;
    private PreguntaDTOPeticion idPregunta;
   
}
