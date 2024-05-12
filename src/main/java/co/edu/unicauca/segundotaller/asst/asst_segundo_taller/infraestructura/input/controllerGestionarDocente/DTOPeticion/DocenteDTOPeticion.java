package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion;



import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion 
{
    @NotNull(message = "{docente.iddocente.emply}")
    private int iddocente;

    @NotNull(message = "{docente.tipoidentificacion.emply}")
    @Size(min = 5, max = 45, message = "{docente.tipoidentificacion.size}")
    private String tipoIdentificacion;

    @NotNull(message = "{docente.numeroidentificacion.emply}")
    @Size(min = 1, max = 10, message = "{docente.numeroidentificacion.size}")
    private String numeroidentificacion;

    @NotNull(message = "{docente.nombres.emply}")
    @Size(min = 3, max = 20, message = "{docente.nombres.size}")
    private String nombres;

    @NotNull(message = "{docente.apellidos.emply}")
    @Size(min = 3, max = 20, message = "{docente.apellidos.size}")
    private String apellidos;

    @NotNull(message = "{docente.correo.emply}")
    @Size(min = 30, max = 30, message = "{docente.correo.size}")
    private String correo;

    @NotNull(message = "{docente.vinculacion.emply}")
    @Size(min = 7, max = 30, message = "{docente.vinculacion.size}")
    private String vinculacion;

    //TODO anotation
    private TelefonoDTOPeticion objPeticionTel;

    @NotNull(message = "")
    private List<Integer> departamentos;


    
}
