package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPreguntaDTOPeticion {
    @NotNull(message = "{tipopregunta.enunciado.emply}")
    private int idtipPregunta;
    private String nombre;
    private String  descripcion;
    private List<PreguntaDTOPeticion> preguntaEntity;
} 

