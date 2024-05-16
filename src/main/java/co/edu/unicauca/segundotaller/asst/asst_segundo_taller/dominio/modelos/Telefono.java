package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import lombok.Data;

@Data
public class Telefono 

{
    
    private Integer idtelefono;
    private String tipotelefono;
    private String numero;
    private Docente objDocente;
    public Telefono()
    {}
     
    public Telefono(Integer idtelefono, String tipotelefono, String numero)
    {
        this.idtelefono = idtelefono;
        this.tipotelefono = tipotelefono;
        this.numero = numero;
    }
}
