package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TipoPregunta 
{
    private Integer idtippregunta;
    private String nombre;
    private String descripcion;
    private List<Pregunta> listaPregunta;
    public TipoPregunta(Integer idtippregunta, String nombre, String descripcion, List<Pregunta> listaPregunta) {
        this.idtippregunta = idtippregunta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaPregunta = listaPregunta;
    }
    public TipoPregunta(){
        this.listaPregunta = new ArrayList<>();
    }
}
