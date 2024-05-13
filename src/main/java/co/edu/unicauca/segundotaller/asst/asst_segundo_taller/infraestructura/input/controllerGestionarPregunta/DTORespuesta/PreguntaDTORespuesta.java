package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTORespuesta {
    private int idpregunta;
    private String enunciado;
    private List<RespuestaDTORespuesta> respuestas;
    private int idTipoPregunta;
    private int idCuestionario;
    public PreguntaDTORespuesta(){
        this.respuestas = new ArrayList<>();
    }

}
