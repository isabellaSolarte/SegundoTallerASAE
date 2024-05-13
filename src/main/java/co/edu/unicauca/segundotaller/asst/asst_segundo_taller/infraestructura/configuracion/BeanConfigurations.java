package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.ExcepcionFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.casosDeUso.GestionarCuestionarioCUAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public GestionarCuestionarioCUAdapter gestionarCuestionarioCUInt(
        GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway, 
        ExcepcionFormateadorResultadosIntPort objCuestionarioFormateadorResultados
    ){
        GestionarCuestionarioCUAdapter objGestionarCuestionarioCUAdapter = new GestionarCuestionarioCUAdapter(objGestionarCuestionarioGateway, objCuestionarioFormateadorResultados);
        return objGestionarCuestionarioCUAdapter;
    }
}
