package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Respuesta")
public class Respuesta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrespuesta;

    @Column(nullable = false, length = 30)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta objPregunta;

    @ManyToOne
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente objDocente;


}
