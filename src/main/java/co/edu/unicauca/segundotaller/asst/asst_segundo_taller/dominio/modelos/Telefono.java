package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Telefono 

{
    
    private Integer idtelefono;
    private String tipotelefono;
    private String numero;
    private Docente objDocente;

    public Telefono()
    {}
}
