package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Docente extends Persona
{
    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Respuesta> respuestas;
    private List<Departamento> listaDepartamentos;

    public Docente(Integer id, String tipoId, String numeroId, String nombres,
                     String apellidos, String correo, String vinculacion, Telefono objTelefono)
    {
        super(id, tipoId, numeroId, nombres, apellidos);
        this.respuestas = new ArrayList<>();
        this.listaDepartamentos = new ArrayList<>();
    }
}