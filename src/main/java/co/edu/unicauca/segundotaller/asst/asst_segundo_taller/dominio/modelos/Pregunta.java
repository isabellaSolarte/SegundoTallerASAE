package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta 
{
    private int idpregunta;
    private String enunciado;
    private TipoPregunta objTipoPreguntaEntity;
    private Cuestionario objCuestionario;
    private List<Respuesta> respuestaEntities;
}
