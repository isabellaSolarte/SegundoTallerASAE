package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;

public interface GestionarDocenteGatewayIntPort 
{
    public boolean existeUsuarioPorId(Integer integer);
    public boolean existeUsuarioPorCorreo(String correo);
    public Docente guardar(Docente objDocente);
    public List<Docente> listar();
}