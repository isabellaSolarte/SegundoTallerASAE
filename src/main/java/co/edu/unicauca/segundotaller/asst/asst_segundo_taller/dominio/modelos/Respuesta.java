package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Respuesta 
{
    private Integer idrespuesta;
    private String descripcion;
    private Pregunta objPregunta;
    private Docente objDocente;

    public Respuesta()
    {}
}
