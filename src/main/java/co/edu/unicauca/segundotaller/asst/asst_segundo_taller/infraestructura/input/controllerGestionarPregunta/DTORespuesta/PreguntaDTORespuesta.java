package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion.TipoPreguntaDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.RespuestaDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreguntaDTORespuesta {
    private int idpregunta;
    private String enunciado;
    private List<RespuestaDTORespuesta> respuestas;
    private TipoPreguntaDTORespuesta idTipoPregunta;
    private int idCuestionario;
    public PreguntaDTORespuesta(int idpregunta, String enunciado, List<RespuestaDTORespuesta> respuestas, TipoPreguntaDTORespuesta idTipoPregunta, int idCuestionario) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.idTipoPregunta = idTipoPregunta;
        this.idCuestionario = idCuestionario;
    }
    public PreguntaDTORespuesta(){
        this.respuestas = new ArrayList<>();
    }

}
