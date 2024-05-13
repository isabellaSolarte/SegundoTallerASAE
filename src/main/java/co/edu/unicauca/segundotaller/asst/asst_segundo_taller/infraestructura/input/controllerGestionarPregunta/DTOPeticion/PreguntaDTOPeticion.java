package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.RespuestaDTOPeticion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreguntaDTOPeticion {
    private int idpregunta;

    @NotNull(message = "{pregunta.enunciado.emply}")
    @Size(min = 3, max = 400, message = "{pregunta.enunciado.size}")
    private String enunciado;

    List<RespuestaDTOPeticion> respuestas;
  
    @NotNull(message = "{pregunta.idTipoPregunta.emply}")
    private int idTipoPregunta;
    private int idCuestionario;

    public PreguntaDTOPeticion(){
        this.respuestas = new ArrayList<>();
    }

}
