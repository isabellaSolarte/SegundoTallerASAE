package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTORespuesta;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoPreguntaDTORespuesta {
    private int idtippregunta;
    public TipoPreguntaDTORespuesta() {
        // Default constructor
    }

    public TipoPreguntaDTORespuesta(int idtippregunta) {
        this.idtippregunta = idtippregunta;
    }
}
