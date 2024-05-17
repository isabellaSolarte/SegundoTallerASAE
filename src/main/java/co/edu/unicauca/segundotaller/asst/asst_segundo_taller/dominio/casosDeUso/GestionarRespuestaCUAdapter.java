package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.ExcepcionFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;

public class GestionarRespuestaCUAdapter implements GestionarRespuestaCUIntPort
{
    private final GestionarRespuestaGatewayIntPort objGestionarRespuestaGateway;
    private final ExcepcionFormateadorResultadosIntPort objRespuestaFormateadorResultados;

    public GestionarRespuestaCUAdapter(GestionarRespuestaGatewayIntPort objGestionarRespuestaGateway, ExcepcionFormateadorResultadosIntPort objRespuestaFormateadorResultados)
    {
        this.objGestionarRespuestaGateway = objGestionarRespuestaGateway;
        this.objRespuestaFormateadorResultados = objRespuestaFormateadorResultados;
    }
    @Override
    public Respuesta crear(Respuesta objRespuesta) 
    {
        Respuesta objRespuestaCreada = null;
        if(this.objGestionarRespuestaGateway.existeRespuestaPorId(objRespuesta.getIdRespuesta()))
        {
            this.objRespuestaFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, el id de la respuesta ya existe");
        }else
        {
            objRespuestaCreada = this.objGestionarRespuestaGateway.guardar(objRespuesta);
        }
        return objRespuestaCreada;
    }

    @Override
    public List<Respuesta> listar() 
    {
        List<Respuesta> listaObtenida = objGestionarRespuestaGateway.listar();
        return listaObtenida;
    }
    
}
