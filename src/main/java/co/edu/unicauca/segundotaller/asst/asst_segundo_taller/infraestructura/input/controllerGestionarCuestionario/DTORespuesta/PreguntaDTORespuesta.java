package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTORespuesta 
{
    private int idpregunta;

    @NotNull(message = "{pregunta.enunciado.emply}")
    @Size(min = 3, max = 400, message = "{pregunta.enunciado.size}")
    private String enunciado;

    @Valid
    private TipoPreguntaDTORespuesta objTipoPreguntaEntity;
}
