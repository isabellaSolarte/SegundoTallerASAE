package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.casosDeUso;


import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.ExcepcionFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;

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
        Pregunta preguntaCreada=null;

        if(this.objGestionarRespuestaGateway.validarDocenteCuestionario(docente,cuestionario)){
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, El docente ya respondio el cuestionario");
        }
        preguntaCreada=this.objGestionarRespuestaGateway.guardar(pregunta,cuestionario,docente);

        return preguntaCreada;
    }

    @Override
    public Docente listar(int idDocente) {
        return this.objGestionarRespuestaGateway.obtenerDocenteCuestionario(idDocente);
    }
    
}
