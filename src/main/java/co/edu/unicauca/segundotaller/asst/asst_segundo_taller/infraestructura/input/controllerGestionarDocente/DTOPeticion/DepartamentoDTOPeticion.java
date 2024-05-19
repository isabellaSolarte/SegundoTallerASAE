package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTOPeticion {
     @NotNull(message = "{departamento.iddepartamento.emply}")
    private int idDepartamento;


    public DepartamentoDTOPeticion()
    {}
}
