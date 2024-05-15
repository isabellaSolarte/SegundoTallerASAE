package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion.PreguntaDTOPeticion;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CuestionarioDTOPeticion {
    private int idcuestionario;

    @NotNull(message = "{cuestionario.titulo.emply}")
    @Size(min = 3, max = 100, message = "{cuestionario.titulo.size}")
    private String titulo;

    @NotNull(message = "{cuestionario.descripcion.emply}")
    @Size(min = 3, max = 400, message = "{cuestionario.descripcion.size}")
    private String descripcion;

   private List<PreguntaDTOPeticion> preguntas;

   
   public CuestionarioDTOPeticion(){
    this.preguntas = new ArrayList<PreguntaDTOPeticion>();
   }

    public CuestionarioDTOPeticion(int idcuestionario, String titulo, String descripcion, List<PreguntaDTOPeticion> preguntas) {
        this.idcuestionario = idcuestionario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.preguntas=preguntas; 
    }
    

}
