package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Docente extends Persona
{
    private String correo;
    private String vinculacion;
    private Telefono objTelefonoEntity;
    private List<Departamento> listaDepartamentos;
    private List<Respuesta> respuestaEntities;

}
