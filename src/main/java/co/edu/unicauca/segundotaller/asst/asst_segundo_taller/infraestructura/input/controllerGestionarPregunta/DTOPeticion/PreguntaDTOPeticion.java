package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.RespuestaDTOPeticion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PreguntaDTOPeticion {
    private int idpregunta;

    @NotNull(message = "{pregunta.enunciado.emply}")
    @Size(min = 3, max = 400, message = "{pregunta.enunciado.size}")
    private String enunciado;

  
    @NotNull(message = "{pregunta.idTipoPregunta.emply}")
    private TipoPreguntaDTOPeticion objTipoPregunta;


    public PreguntaDTOPeticion(int idpregunta, String enunciado, List<RespuestaDTOPeticion> respuestas, TipoPreguntaDTOPeticion objTipoPregunta) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.objTipoPregunta = objTipoPregunta;
    }
    public PreguntaDTOPeticion(){
    }

}
