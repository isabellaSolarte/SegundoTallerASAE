package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;

public interface GestionarRespuestaGatewayIntPort 
{
    public boolean existeRespuestaPorId(Integer idrespuesta);
    public Respuesta guardar(Respuesta objRespuesta);
    public List<Respuesta> listar();
    //consultarRespuestasDocente(Integer idDocente);
    
} 