package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta 
{
    private int idRespuesta;
    private String descripcion;
    private Docente objUsuario;
    private Pregunta objPreguntaEntity;
}
