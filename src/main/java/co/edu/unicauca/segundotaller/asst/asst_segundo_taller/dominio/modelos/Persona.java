package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona 
{
    private Integer idpersona;
    private String tipoidentificacion;
    private String numeroidentificacion;
    private String nombres;
    private String apellidos;
    
    public Persona()
    {}
}
