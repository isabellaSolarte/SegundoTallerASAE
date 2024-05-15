package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion.CuestionarioDTOPeticion;
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

    List<RespuestaDTOPeticion> respuestas;
  
    @NotNull(message = "{pregunta.idTipoPregunta.emply}")
    private TipoPreguntaDTOPeticion objTipoPregunta;
    private CuestionarioDTOPeticion objCuestionario;


    public PreguntaDTOPeticion(int idpregunta, String enunciado, List<RespuestaDTOPeticion> respuestas, TipoPreguntaDTOPeticion objTipoPregunta, CuestionarioDTOPeticion objCuestionario) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.objTipoPregunta = objTipoPregunta;
        this.objCuestionario = objCuestionario;
    }
    public PreguntaDTOPeticion(){
        this.respuestas = new ArrayList<RespuestaDTOPeticion>();
    }

}
