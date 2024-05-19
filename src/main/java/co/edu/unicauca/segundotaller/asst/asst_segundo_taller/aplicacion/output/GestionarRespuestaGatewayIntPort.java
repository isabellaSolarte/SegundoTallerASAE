package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;

public interface GestionarRespuestaGatewayIntPort 
{
    public boolean existeRespuestaCuestionario(int codigo);
    public Pregunta guardar(Pregunta pregunta, Cuestionario cuestionario, Docente docente);
    public boolean validarDocenteCuestionario(Docente docente, Cuestionario cuestionario);
    public Docente obtenerDocenteCuestionario(int codigo);
} 