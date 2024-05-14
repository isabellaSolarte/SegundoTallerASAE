package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "TipoPregunta")
public class TipoPreguntaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtippregunta;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objTipoPregunta")
    private List<PreguntaEntity> listaPregunta;

    public TipoPreguntaEntity(Integer idtippregunta, String nombre, String descripcion, List<PreguntaEntity> listaPregunta) {
        this.idtippregunta = idtippregunta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaPregunta = listaPregunta;
    }
    public TipoPreguntaEntity(){
        this.listaPregunta = new ArrayList<>();
    }
    
}