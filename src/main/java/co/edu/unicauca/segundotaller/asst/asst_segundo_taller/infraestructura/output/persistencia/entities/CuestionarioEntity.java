package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;

import lombok.*;
import java.util.ArrayList;
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

@Getter
@Setter
@Entity
@Builder
@Table(name = "Cuestionarios")

public class CuestionarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcuestionario;

    @Column( nullable = false, length = 30)
    private String titulo;

    @Column( nullable = false, length = 30)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "objCuestionario")
    private List<PreguntaEntity> preguntas;
    
    public CuestionarioEntity(Integer idcuestionario, String titulo, String descripcion, List<PreguntaEntity> preguntas) {
        this.idcuestionario = idcuestionario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
    }
    public CuestionarioEntity(){
        this.preguntas = new ArrayList<>();
    }

}
