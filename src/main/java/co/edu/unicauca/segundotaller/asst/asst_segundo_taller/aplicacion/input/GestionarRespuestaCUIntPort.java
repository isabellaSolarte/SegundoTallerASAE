package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Pregunta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;


public interface GestionarRespuestaCUIntPort 
{
    public Pregunta crear(Docente docente, Cuestionario cuestionario, Pregunta pregunta);
    public Docente listar(int idDocente);
    public Docente buscarPorId(Integer id);
    public List<Respuesta> buscarRespuestaPorIdDocente(Integer id);
}
