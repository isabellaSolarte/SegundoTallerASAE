package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteCUDTORespuesta 
{
    private int idpersona;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo ;
    private String vinculacion;
    private List<RespuestaDTORespuesta> respuestaEntities;

    public DocenteCUDTORespuesta(){};
    
    
}
