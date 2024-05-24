package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.casosDeUso;


import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.ExcepcionFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;
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
    public Pregunta crear(Docente docente, Cuestionario cuestionario, Pregunta pregunta) {
        Pregunta preguntaN=null;

        if(this.objGestionarRespuestaGateway.validarDocenteCuestionario(docente,cuestionario)){
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, El docente ya respondio el cuestionario");
        }
        
        preguntaN=this.objGestionarRespuestaGateway.guardar(pregunta,cuestionario,docente);

        return preguntaN;
    }

    @Override
    public Docente listar(int idDocente) {
        return this.objGestionarRespuestaGateway.obtenerDocenteCuestionario(idDocente);
    }
    @Override
    public Docente buscarPorId(Integer id) {
        return this.objGestionarRespuestaGateway.buscarPorId(id);
    }
    @Override
    public List<Respuesta> buscarRespuestaPorIdDocente(Integer id) {
        
        return this.objGestionarRespuestaGateway.buscarRespuestaPorIdDocente(id);
    }
    
}
