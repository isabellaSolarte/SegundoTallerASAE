package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    
    @Bean
    public ModelMapper crearMapper(){
        return new ModelMapper();
    } 
}
