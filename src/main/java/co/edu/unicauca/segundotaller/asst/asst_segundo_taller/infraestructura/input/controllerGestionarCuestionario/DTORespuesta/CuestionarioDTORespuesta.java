package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta;

import java.util.ArrayList;
import java.util.List;


import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTORespuesta.PreguntaDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuestionarioDTORespuesta {
    private int idcuestionario;
    private String titulo;
    private String descripcion;
    List<PreguntaDTORespuesta> preguntas;
    public CuestionarioDTORespuesta(int idcuestionario, String titulo, String descripcion, List<PreguntaDTORespuesta> preguntas) {
        this.idcuestionario = idcuestionario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
    }
    public CuestionarioDTORespuesta(){
        this.preguntas = new ArrayList<>();
    }
}
