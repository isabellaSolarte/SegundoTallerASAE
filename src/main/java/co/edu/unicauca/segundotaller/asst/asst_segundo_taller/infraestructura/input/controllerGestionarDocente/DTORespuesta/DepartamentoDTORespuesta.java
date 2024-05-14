package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTORespuesta 
{
    @NotNull(message = "{departamento.iddepartamento.emply}")
    private int iddepartamento;

    @NotNull(message = "{departamento.nombre.emply}")
    @Size(min = 5, max = 25, message = "{departamento.nombre.size}")
    private String nombre;

    @NotNull(message = "{departamento.descripcion.emply}")
    @Size(min = 5, max = 35, message = "{departamento.descripcion.size}")
    private String descripcion;
    public DepartamentoDTORespuesta()
    {}
}
