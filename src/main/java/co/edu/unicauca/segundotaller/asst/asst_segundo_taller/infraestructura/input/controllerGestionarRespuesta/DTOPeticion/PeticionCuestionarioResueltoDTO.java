package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PeticionCuestionarioResueltoDTO 
{
    private CuestionarioDTOPeticion objCuestionario;
    private DocenteDTOPeticion objDocente;
    private PreguntaDTOPeticion objPregunta;
}
