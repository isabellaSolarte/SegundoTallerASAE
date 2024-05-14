package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Docente extends Persona
{
    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Respuesta> respuestas;
    private List<Departamento> listaDepartamentos;

    Docente()
    {
        this.respuestas = new ArrayList<>();
        this.listaDepartamentos = new ArrayList<>();
    }

    public Docente( String tipoIdentificacion, String numeroIdentificacion, String nombres,
                    String apellidos, String correo, String vinculacion, Telefono telefono) {
        super( tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.objTelefono=telefono;
    }
}
