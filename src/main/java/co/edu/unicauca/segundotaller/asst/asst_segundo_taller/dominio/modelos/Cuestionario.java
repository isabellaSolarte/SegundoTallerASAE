package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cuestionario 
{
    private int idcuestionario;
    private String titulo;
    private String descripcion;
    private List<Pregunta> preguntas;

    public Cuestionario()
    {
        this.preguntas = new ArrayList<>();
    }
}