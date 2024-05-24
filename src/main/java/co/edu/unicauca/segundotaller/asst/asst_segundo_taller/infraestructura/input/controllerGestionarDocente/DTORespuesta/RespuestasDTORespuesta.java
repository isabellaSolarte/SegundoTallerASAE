package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestasDTORespuesta 
{
    private int idRespuesta;
    private String descripcion;
    private DocenteDTORespuesta objUsuario;
    private PreguntaDTORespuesta objPreguntaEntity;
}
