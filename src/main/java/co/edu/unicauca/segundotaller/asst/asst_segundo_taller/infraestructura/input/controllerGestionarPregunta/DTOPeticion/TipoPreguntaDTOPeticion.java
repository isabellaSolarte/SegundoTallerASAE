package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoPreguntaDTOPeticion {
    private int idtippregunta;
    public TipoPreguntaDTOPeticion() {
        // Constructor sin parámetros
    }

    public TipoPreguntaDTOPeticion(int idtippregunta) {
        this.idtippregunta = idtippregunta;
    }

}
