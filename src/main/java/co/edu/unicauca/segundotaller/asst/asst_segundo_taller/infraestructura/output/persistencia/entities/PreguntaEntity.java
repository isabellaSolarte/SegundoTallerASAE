package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Preguntas")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPregunta")
    private int idpregunta;

    @Column(name = "enunciado",length = 30)
    private String enunciado;

    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER )
    @JoinColumn(name = "idtipPregunta")
    private TipoPreguntaEntity objTipoPreguntaEntity;

    @ManyToOne
    @JoinColumn(name="idCuestionario", nullable=false)
    private CuestionarioEntity objCuestionarioEntity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "objPreguntaEntity")
    private List<RespuestaEntity> respuestaEntities;
}