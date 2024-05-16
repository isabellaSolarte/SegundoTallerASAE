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
    private Integer idpregunta;
    private String enunciado;
  
    private TipoPregunta objTipoPregunta;
    
    public Pregunta( Integer idpregunta,String enunciado, List<Respuesta> respuestas, TipoPregunta objTipoPregunta) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.objTipoPregunta = objTipoPregunta;
    }
    public Pregunta()
    {
    }
}
