package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "Departamentos")
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepartamento")
    private int iddepartamento;
    @Column(name = "nombredep",length = 30)
    private String nombre;
    @Column(name = "descripcion",length = 30)
    private String descripcion;

}
