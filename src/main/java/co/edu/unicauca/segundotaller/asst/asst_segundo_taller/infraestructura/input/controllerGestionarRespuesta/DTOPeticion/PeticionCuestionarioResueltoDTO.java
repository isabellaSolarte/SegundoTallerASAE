package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PeticionCuestionarioResueltoDTO 
{
    @Valid
    @NotNull(message = "{cuestionario.objCuestionario.emply}")
    private CuestionarioDTOPeticion objCuestionario;

    @Valid
    @NotNull(message = "{docente.objDocente.emply}")
    private DocenteDTOPeticion objDocente;

    @Valid
    @NotNull(message = "{pregunta.objPregunta.emply}")
    private PreguntaDTOPeticion objPregunta;
}
