package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Cuestionario 
{
    private int idcuestionario;
    private String titulo;
    private String descripcion;
    private List<Pregunta> preguntas;
    public Cuestionario(int idcuestionario, String titulo, String descripcion, List<Pregunta> preguntas) {
        this.idcuestionario = idcuestionario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
    }
    public Cuestionario()
    {
        this.preguntas = new ArrayList<>();
    }
}