package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "Docentes")
public class DocenteEntity extends PersonaEntity{

    @Column(nullable = false, length = 30)
    private String correo;

    @Column(nullable = false, length = 30)
    private String vinculacion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objDocente")
    private TelefonoEntity objTelefono;

    @OneToMany( mappedBy = "objDocente", fetch = FetchType.EAGER)
    private List<RespuestaEntity> respuestas;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name="DocenteDepartamento",
                joinColumns = @JoinColumn(name="iddocente"),
                inverseJoinColumns = @JoinColumn(name="iddepartamento"))
    private List<DepartamentoEntity> listaDepartamentos;

    public DocenteEntity(){
        this.listaDepartamentos = new ArrayList<>();
    }

}

