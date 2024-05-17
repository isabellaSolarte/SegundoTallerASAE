package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion.PreguntaDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaDTORespuesta {
    private int idRespuesta;
    private String descripcion;
    private DocenteDTORespuesta objUsuario;
    private PreguntaDTORespuesta idPregunta;
    
}
