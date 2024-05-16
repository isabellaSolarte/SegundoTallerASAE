package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion;
import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.PreguntaEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TipoPreguntaDTOPeticion {
    private int idtippregunta;
    private String nombre;
    private String descripcion;
    private List<PreguntaDTOPeticion> listaPregunta;
    public TipoPreguntaDTOPeticion() {}

    public TipoPreguntaDTOPeticion(Integer idtippregunta, String nombre, String descripcion, List<PreguntaDTOPeticion> listaPregunta) {
        this.idtippregunta = idtippregunta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaPregunta = listaPregunta;
    }

}
