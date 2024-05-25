package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.*;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.PreguntaDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.DocenteCUDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestasDTORespuesta;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RespuestaMapperInfraestructuraDominio 
{
    Pregunta mappearDePeticionARespuesta(PreguntaDTOPeticion peticion);
    PreguntaDTORespuesta mappearDeRespuestaCARespuesta(Pregunta objPregunta);
    DocenteDTORespuesta mappearDeRespuestaCARespuesta(Docente objDocente);
    List<RespuestaDTORespuesta> mappearDeRespuestaCARespuesta(List<Respuesta> respuestas);
    RespuestasDTORespuesta mappearDeRespuestasCARespuestas(Respuesta respuestas);
    Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion);
    @Mappings({
        @Mapping(source = "idPersona", target = "idPersona")
    })
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);
    DocenteCUDTORespuesta mappearDeRespuestaCURespuesta(Docente objDocente);
}
