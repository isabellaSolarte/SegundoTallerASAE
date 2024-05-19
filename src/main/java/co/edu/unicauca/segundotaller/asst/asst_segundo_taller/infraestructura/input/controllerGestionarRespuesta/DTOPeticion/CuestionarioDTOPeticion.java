package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTOPeticion 
{
    @NotNull(message = "{cuestionario.id.emply}")
    private int idCuestionario;
    public CuestionarioDTOPeticion(){}
}
