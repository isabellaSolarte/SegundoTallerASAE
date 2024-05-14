package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.RespuestaDTOPeticion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTORespuesta 
{
    @NotNull(message = "{docente.iddocente.emply}")
    private int idpersona;

    @NotNull(message = "{docente.tipoidentificacion.emply}")
    @Size(min = 5, max = 45, message = "{docente.tipoidentificacion.size}")
    private String tipoidentificacion;

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
    @Size(min = 10, max = 30, message = "{docente.correo.size}")
    private String correo;

    private List<RespuestaDTOPeticion> respuestas; 

    @NotNull(message = "{docente.vinculacion.emply}")
    @Size(min = 7, max = 30, message = "{docente.vinculacion.size}")
    private String vinculacion;

    @Pattern(regexp = "(?:3[0-9]{9})|(?:[1-9][0-9]{8})", message = "{telefono.size.pattern}")
    private TelefonoDTORespuesta objTelefono;
    

    @NotNull(message = "")
    private List<DepartamentoDTORespuesta> listaDepartamentos;
    public DocenteDTORespuesta()
    {
        
    }
    
    
}
