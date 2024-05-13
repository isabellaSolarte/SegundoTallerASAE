package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TelefonoDTORespuesta 
{
     @NotNull(message = "{telefono.idtelefono.emply}")
    private int idtelefono;

    @NotNull(message = "{telefono.tipotelefono.emply}")
    @Size(min = 5, max = 25, message = "{telefono.tipotelefono.size}")
    private String tipotelefono;

    @NotNull(message = "{telefono.numero.emply}")
    @Size(min = 10, max = 12, message = "{docente.numero.size}")
    private String numero;
    
}
