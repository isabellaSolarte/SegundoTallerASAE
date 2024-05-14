package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
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

    @OneToOne
    @JoinColumn(name="idDocente")
    private DocenteEntity objDocente;

    public TelefonoEntity(Integer idtelefono, String tipotelefono, String numero, DocenteEntity objDocente)
    {
        this.idtelefono = idtelefono;
        this.tipotelefono = tipotelefono;
        this.numero = numero;
        this.objDocente = objDocente;
    }
    
}