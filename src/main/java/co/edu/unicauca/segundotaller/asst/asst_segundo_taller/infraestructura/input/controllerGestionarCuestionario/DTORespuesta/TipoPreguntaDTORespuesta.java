package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoPreguntaDTORespuesta 
{
    private int idtipPregunta;

    @NotNull(message = "{tipopregunta.nombre.emply}")
    @Size(min = 3, max = 15, message = "{tipopregunta.nombre.size}")
    private String nombre;
     
    @NotNull(message = "{tipopregunta.descripcion.emply}")
    @Size(min = 3, max = 40, message = "{tipopregunta.descripcion.size}")
    private String  descripcion;
}
