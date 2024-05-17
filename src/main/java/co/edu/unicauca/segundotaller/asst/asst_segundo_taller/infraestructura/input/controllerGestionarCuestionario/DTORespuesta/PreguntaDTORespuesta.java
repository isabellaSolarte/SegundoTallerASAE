package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTORespuesta {
    private int idpregunta;
    private String enunciado;
    private TipoPreguntaDTORespuesta objTipoPreguntaEntity;
}
