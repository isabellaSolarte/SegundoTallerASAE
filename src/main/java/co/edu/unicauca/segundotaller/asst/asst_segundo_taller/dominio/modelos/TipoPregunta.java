package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoPregunta 
{
    private Integer idtippregunta;
    private String nombre;
    private String descripcion;
    private List<Pregunta> listaPregunta;

    public TipoPregunta(){
        this.listaPregunta = new ArrayList<>();
    }
}
