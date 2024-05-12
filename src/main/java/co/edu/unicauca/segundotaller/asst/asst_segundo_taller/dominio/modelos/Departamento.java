package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Departamento 
{
    
    private int iddepartamento;
    private String nombre;
    private String descripcion;



    public Departamento()
    {}
}