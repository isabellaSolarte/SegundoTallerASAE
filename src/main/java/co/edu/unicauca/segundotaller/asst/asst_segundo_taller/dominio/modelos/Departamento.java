package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento 
{
    private int idDepartamento;
    private String nombre;
    private String descripcion;

}