package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTORespuesta;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion.PreguntaDTOPeticion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoPreguntaDTORespuesta {
    private int idtippregunta;
    private String nombre;
    private String descripcion;
    private List<PreguntaDTORespuesta> listaPregunta;
    public TipoPreguntaDTORespuesta() {
    }

    public TipoPreguntaDTORespuesta(Integer idtippregunta, String nombre, String descripcion, List<PreguntaDTORespuesta> listaPregunta) {
        this.idtippregunta = idtippregunta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaPregunta = listaPregunta;
    }
}
