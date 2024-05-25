package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CuestionarioDTORespuesta 
{
    private int idCuestionario;
    
    @NotNull(message = "{cuestionario.titulo.emply}")
    @Size(min = 3, max = 100, message = "{cuestionario.titulo.size}")
    private String titulo;    
    
    @NotEmpty(message = "{cuestionario.descripcion.emply}")
    @Size(min = 3, max = 400, message = "{cuestionario.descripcion.size}")
    private String descripcion;

    @Valid
    private List<PreguntaDTORespuesta> preguntaEntities;

    public CuestionarioDTORespuesta(){}
  
}
