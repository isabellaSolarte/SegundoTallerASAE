package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "TipoPregunta")
public class TipoPregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtippregunta;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objTipoPregunta")
    private List<Pregunta> listaPregunta;

    public TipoPregunta(){
        this.listaPregunta = new ArrayList<>();
    }
    
}