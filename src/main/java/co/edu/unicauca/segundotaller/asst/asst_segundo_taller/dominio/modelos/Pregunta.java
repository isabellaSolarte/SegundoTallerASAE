package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Pregunta 
{
    
    private int idpregunta;
    private String enunciado;
    private List<Respuesta> respuestas;
    private TipoPregunta objTipoPregunta;
    private Cuestionario objCuestionario;
    
    public Pregunta(int idpregunta, String enunciado, List<Respuesta> respuestas, TipoPregunta objTipoPregunta, Cuestionario objCuestionario) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.objTipoPregunta = objTipoPregunta;
        this.objCuestionario = objCuestionario;
        this.respuestas = new ArrayList<>();
    }
    public Pregunta()
    {
        this.respuestas = new ArrayList<>();
    }
}
