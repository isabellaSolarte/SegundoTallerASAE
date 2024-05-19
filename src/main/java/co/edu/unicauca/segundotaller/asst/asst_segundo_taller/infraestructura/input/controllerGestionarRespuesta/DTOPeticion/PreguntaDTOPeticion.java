package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTOPeticion 
{
    @NotNull(message = "{pregunta.id.emply}")
    private int idpregunta;

    @NotNull(message = "{cuestionario.preguntas.emply}")
    private List<RespuestaDTOPeticion> respuestas;
    public PreguntaDTOPeticion(){}
}

