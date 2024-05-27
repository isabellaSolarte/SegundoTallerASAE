package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion;



import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TelefonoDTOPeticion 
{
    @NotNull(message = "{telefono.idtelefono.emply}")
    private int idTelefono;

    @NotNull(message = "{telefono.tipotelefono.emply}")
    @Size(min = 5, max = 25, message = "{telefono.tipotelefono.size}")
    private String tipoTelefono;

    @NotNull(message = "{telefono.numero.emply}")
    @Pattern(regexp = "3[0-9]{9}", message = "{telefono.size.pattern}")
    private String numero;
    
    @Valid
    private DocenteDTOPeticion objPersona;
    public TelefonoDTOPeticion()
    {}
    
}

