package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDTORespuesta 
{
    private int idpregunta;
    private String enunciado;
    private TipoPreguntaDTORespuesta objTipoPreguntaEntity;
    private CuestionarioDTORespuesta objCuestionario;
}
