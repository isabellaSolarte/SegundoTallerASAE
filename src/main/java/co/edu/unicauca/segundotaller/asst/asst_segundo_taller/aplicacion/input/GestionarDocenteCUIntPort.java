package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;

public interface GestionarDocenteCUIntPort 
{
    public Docente crear(Docente objDocente);
    public List<Docente> listar();
}
