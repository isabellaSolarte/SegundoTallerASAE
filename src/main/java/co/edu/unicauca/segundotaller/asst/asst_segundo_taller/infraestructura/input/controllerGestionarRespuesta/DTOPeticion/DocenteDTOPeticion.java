package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion {
    @NotNull(message = "{docente.iddocente.emply}")
    private int idPersona;
    public DocenteDTOPeticion(){};
}