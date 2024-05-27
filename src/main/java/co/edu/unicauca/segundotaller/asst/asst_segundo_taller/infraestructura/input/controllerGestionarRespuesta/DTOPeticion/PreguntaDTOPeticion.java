package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import jakarta.validation.Valid;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTOPeticion 
{
    @NotNull(message = "{pregunta.id.emply}")
    private int idpregunta;

    @Valid
    @NotNull(message = "{cuestionario.preguntas.emply}")
    private List<RespuestaDTOPeticion> respuestaEntities;
    public PreguntaDTOPeticion(){}
}

