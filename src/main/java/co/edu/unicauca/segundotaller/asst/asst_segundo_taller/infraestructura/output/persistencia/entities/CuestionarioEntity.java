package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;

import lombok.*;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cuestionarios")
public class CuestionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCuestionario")
    private int idCuestionario;

    @Column(name = "titulo",length = 30)
    private String titulo;

    @Column(name = "descripcion",length = 30)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER, mappedBy = "objCuestionarioEntity")
    private List<PreguntaEntity> preguntaEntities;
}
