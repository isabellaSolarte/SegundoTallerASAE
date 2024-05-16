package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Telefono")
public class TelefonoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtelefono;

    @Column(nullable = false, length = 30)
    private String tipotelefono;

    @Column(nullable = false, length = 30)
    private String numero;

    //@OneToOne
    //@JoinColumn(name="idDocente")
    //private DocenteEntity objDocente;
    @MapsId
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name="idDocente")
    private DocenteEntity objDocente;

   
    
}