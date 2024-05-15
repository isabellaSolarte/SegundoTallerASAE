package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarPregunta.DTOPeticion.PreguntaDTOPeticion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class RespuestaDTOPeticion {
    private int idrespuesta;

    @NotNull(message = "{respuesta.descripcion.emply}")
    @Size(min = 3, max = 400, message = "{respuesta.descripcion.size}")
    private String descripcion;

    private PreguntaDTOPeticion objPregunta;
    private DocenteDTOPeticion objDocente;
    public RespuestaDTOPeticion(){}
    public RespuestaDTOPeticion(int idrespuesta, String descripcion, PreguntaDTOPeticion objPregunta, DocenteDTOPeticion objDocente) 
    {
        this.idrespuesta = idrespuesta;
        this.descripcion = descripcion;
        this.objPregunta = objPregunta;
        this.objDocente = objDocente;
    }

    

}
