package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTORespuesta;

import java.util.ArrayList;
import java.util.List;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreguntaDTORespuesta {
    private int idpregunta;
    private String enunciado;
    private TipoPreguntaDTORespuesta idTipoPregunta;
    private CuestionarioDTORespuesta objCuestionario;
    public PreguntaDTORespuesta(int idpregunta, String enunciado, List<RespuestaDTORespuesta> respuestas, TipoPreguntaDTORespuesta idTipoPregunta, CuestionarioDTORespuesta objCuestionario) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.idTipoPregunta = idTipoPregunta;
        this.objCuestionario = objCuestionario;
    }
    public PreguntaDTORespuesta(){
        
    }

}
