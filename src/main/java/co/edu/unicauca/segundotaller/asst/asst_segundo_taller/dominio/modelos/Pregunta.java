package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pregunta 
{
    
    private int idpregunta;
    private String enunciado;
    private List<Respuesta> respuestas;
    private TipoPregunta objTipoPregunta;
    private Cuestionario objCuestionario;

    public Pregunta()
    {
        this.respuestas = new ArrayList<>();
    }
}
