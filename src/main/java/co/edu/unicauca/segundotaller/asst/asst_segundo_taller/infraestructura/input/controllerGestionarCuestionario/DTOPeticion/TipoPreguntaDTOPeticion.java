package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPreguntaDTOPeticion 
{
    private int idtipPregunta;

    @NotNull(message = "{tipopregunta.nombre.emply}")
    @Size(min = 3, max = 15, message = "{tipopregunta.nombre.size}")
    private String nombre;
     
    @NotNull(message = "{tipopregunta.descripcion.emply}")
    @Size(min = 3, max = 40, message = "{tipopregunta.descripcion.size}")
    private String  descripcion;

    @Valid
    private List<PreguntaDTOPeticion> preguntaEntity;
} 

