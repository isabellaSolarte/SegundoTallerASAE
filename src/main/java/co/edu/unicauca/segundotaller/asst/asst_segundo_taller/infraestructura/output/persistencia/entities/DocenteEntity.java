package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


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

   // @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objDocente")
   @JsonManagedReference
   @OneToOne(mappedBy = "objDocente", cascade = CascadeType.ALL , fetch = FetchType.EAGER) 
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
        this.respuestas = new ArrayList<>();
    }
    public DocenteEntity(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String correo, String vinculacion,
                         TelefonoEntity objTelefono, List<RespuestaEntity> listaRespuestas, List<DepartamentoEntity> listaDepartamentos) {
        super( tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.respuestas = listaRespuestas;
        this.listaDepartamentos = listaDepartamentos;
    }

}

