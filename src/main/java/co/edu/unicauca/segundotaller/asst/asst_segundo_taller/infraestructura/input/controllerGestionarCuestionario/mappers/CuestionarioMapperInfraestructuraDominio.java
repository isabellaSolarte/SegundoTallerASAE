package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.TipoPregunta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.TipoPreguntaDTORespuesta;

@Mapper(componentModel = "spring")
public interface CuestionarioMapperInfraestructuraDominio {
    Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion);
    CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario objCuestionario);
    List<CuestionarioDTORespuesta> mappearDeCuestionariosARespuesta(List<Cuestionario> cuestionarios);
    List<TipoPreguntaDTORespuesta> mappearDeTipoPreguntaARespuesta(List<TipoPregunta> tipoPreguntas);
}
