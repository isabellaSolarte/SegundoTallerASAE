package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TipoPregunta")
public class TipoPreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipPregunta")
    private  int idtipPregunta;
    @Column(name = "nombre",length = 30)
    private String nombre;
    @Column(name = "descripcion",length = 30)
    private String  descripcion;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "objTipoPreguntaEntity")
    private List<PreguntaEntity> preguntaEntity;
}