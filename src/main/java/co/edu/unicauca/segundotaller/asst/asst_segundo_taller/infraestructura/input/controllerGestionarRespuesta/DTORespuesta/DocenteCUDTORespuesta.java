package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteCUDTORespuesta 
{
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo ;
    private String vinculacion;

    public DocenteCUDTORespuesta(){};
    
    
}
