package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Respuesta 
{
    private Integer idrespuesta;
    private String descripcion;
    private Pregunta objPregunta;
    private Docente objDocente;
    public Respuesta(Integer idrespuesta, String descripcion, Pregunta objPregunta, Docente objDocente) {
        this.idrespuesta = idrespuesta;
        this.descripcion = descripcion;
        this.objPregunta = objPregunta;
        this.objDocente = objDocente;
    }
    public Respuesta()
    {}
}
