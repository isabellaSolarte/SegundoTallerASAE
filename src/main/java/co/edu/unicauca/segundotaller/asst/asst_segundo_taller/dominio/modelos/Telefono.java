package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.DocenteEntity;
import lombok.AllArgsConstructor;
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
     
    public Telefono(Integer idtelefono, String tipotelefono, String numero, Docente objDocente)
    {
        this.idtelefono = idtelefono;
        this.tipotelefono = tipotelefono;
        this.numero = numero;
        this.objDocente = objDocente;
    }
}
