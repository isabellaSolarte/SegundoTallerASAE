package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CuestionarioDTORespuesta 
{
    private int idCuestionario;
    private String titulo;
    private String descripcion;
    
}
