package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio 
{
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);

    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente objDocente);

    List<DocenteDTORespuesta> mappearDeProductosARespuesta(List<Docente> docentes);    
}
