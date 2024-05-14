package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Departamento 
{
    
    private int iddepartamento;
    private String nombre;
    private String descripcion;


    public Departamento()
    {}
    public Departamento(int iddepartamento, String nombre, String descripcion)
    {
        this.iddepartamento = iddepartamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}