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
public class Cuestionario 
{
    private int idCuestionario;
    private String titulo;
    private String descripcion;
    private List<Pregunta> preguntaEntities;

}