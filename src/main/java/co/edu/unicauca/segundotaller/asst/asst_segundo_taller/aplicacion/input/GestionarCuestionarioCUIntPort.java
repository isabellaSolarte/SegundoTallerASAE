package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.TipoPregunta;

public interface GestionarCuestionarioCUIntPort 
{
    public Cuestionario crear(Cuestionario objCuestionario);
    public List<Cuestionario> listar();
    public List<TipoPregunta> listaTipoPreguntas();
    // TODOLISTAR CUESTIONATIO CON PREGUNTAS

}
 