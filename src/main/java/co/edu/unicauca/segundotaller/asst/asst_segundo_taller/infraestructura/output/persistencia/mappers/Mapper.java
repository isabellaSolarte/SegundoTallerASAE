package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.input.controllerGestionarCuestionario.DTORespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.CuestionarioEntity;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.PreguntaEntity;

@Configuration
public class Mapper {
    
    @Bean
    public ModelMapper crearMapper(){

        ModelMapper objMapper = new ModelMapper();

        /*TypeMap<CuestionarioEntity, CuestionarioDTORespuesta> mapa = objMapper.emptyTypeMap(CuestionarioEntity.class, CuestionarioDTORespuesta.class);
        mapa.addMappings(m ->
            m.skip(CuestionarioDTORespuesta::setPreguntaEntities)).implicitMappings();
        TypeMap<PreguntaEntity, PreguntaDTORespuesta> mapa2 = objMapper.emptyTypeMap(PreguntaEntity.class, PreguntaDTORespuesta.class);
        mapa2.addMappings(m ->
            m.skip(PreguntaDTORespuesta::setObjTipoPreguntaEntity)).implicitMappings(); */
        
        return objMapper;

    } 
}
