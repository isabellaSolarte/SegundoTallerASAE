package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;


import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;

public interface GestionarRespuestaGatewayIntPort 
{
    public boolean existeRespuestaCuestionario(int codigo);
    public Pregunta guardar(Pregunta pregunta, Cuestionario cuestionario, Docente docente);
    public boolean validarDocenteCuestionario(Docente docente, Cuestionario cuestionario);
    public Docente obtenerDocenteCuestionario(int codigo);
    public Docente buscarPorId(Integer id);
    public List<Respuesta> buscarRespuestaPorIdDocente(Integer id);
} 