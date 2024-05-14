package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder

@Table(name = "Preguntas")
public class PreguntaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpregunta;

    @Column(nullable = false, length = 30)
    private String enunciado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objPregunta")
	private List<RespuestaEntity> respuestas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idTipoPregunta", nullable = false)
    private TipoPreguntaEntity objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idCuestionario", nullable = false)
    private CuestionarioEntity objCuestionario;

    public PreguntaEntity(Integer idpregunta, String enunciado, List<RespuestaEntity> respuestas, TipoPreguntaEntity objTipoPregunta, CuestionarioEntity objCuestionario) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.objTipoPregunta = objTipoPregunta;
        this.objCuestionario = objCuestionario;
    }
    public PreguntaEntity (){
        this.respuestas = new ArrayList<>();
    }

}