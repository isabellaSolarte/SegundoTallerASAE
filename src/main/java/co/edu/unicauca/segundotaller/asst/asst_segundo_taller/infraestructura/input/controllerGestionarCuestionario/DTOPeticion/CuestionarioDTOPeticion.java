package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion.PreguntaDTOPeticion;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CuestionarioDTOPeticion {
    private int idcuestionario;

    @NotNull(message = "{cuestionario.titulo.emply}")
    @Size(min = 3, max = 100, message = "{cuestionario.titulo.size}")
    private String titulo;

    @NotNull(message = "{cuestionario.descripcion.emply}")
    @Size(min = 3, max = 400, message = "{cuestionario.descripcion.size}")
    private String descripcion;

    @NotEmpty(message = "{cuestionario.preguntas.emply}")
    List<PreguntaDTOPeticion> preguntas;
    public CuestionarioDTOPeticion(){
        this.preguntas = new ArrayList<>();
    }

}
