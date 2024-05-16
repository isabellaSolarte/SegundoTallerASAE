package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTORespuesta;

import java.util.List;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreguntaDTORespuesta {
    private Integer idpregunta;
    private String enunciado;
    private TipoPreguntaDTORespuesta objTipoPregunta;
    public PreguntaDTORespuesta(){}
    public PreguntaDTORespuesta( Integer idpregunta,String enunciado, List<RespuestaDTORespuesta> respuestas, TipoPreguntaDTORespuesta objTipoPregunta) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.objTipoPregunta = objTipoPregunta;
    }
    

}
