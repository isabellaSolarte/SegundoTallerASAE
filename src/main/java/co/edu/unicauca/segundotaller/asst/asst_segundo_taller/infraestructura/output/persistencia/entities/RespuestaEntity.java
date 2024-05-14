package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "Respuesta")
public class RespuestaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrespuesta;

    @Column(nullable = false, length = 30)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPregunta", nullable = false)
    private PreguntaEntity objPregunta;

    @ManyToOne
    @JoinColumn(name = "idDocente", nullable = false)
    private DocenteEntity objDocente;
    public RespuestaEntity() {

    }

    public RespuestaEntity(Integer idrespuesta, String descripcion, PreguntaEntity objPregunta, DocenteEntity objDocente) {
        this.idrespuesta = idrespuesta;
        this.descripcion = descripcion;
        this.objPregunta = objPregunta;
        this.objDocente = objDocente;
    }

}
