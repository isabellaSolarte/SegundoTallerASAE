package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Respuesta")
public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRespuesta")
    private int idRespuesta;

    @Column(name = "descripcion",length = 30)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "objDocente")
    private DocenteEntity objDocente;

    @ManyToOne
    @JoinColumn(name = "idpregunta",nullable = false)
    private PreguntaEntity objPreguntaEntity;
}
