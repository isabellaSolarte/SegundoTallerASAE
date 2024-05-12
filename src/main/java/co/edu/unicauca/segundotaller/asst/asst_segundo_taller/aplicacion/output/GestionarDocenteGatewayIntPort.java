package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort 
{
    public boolean existeUsuarioPorCodigo(Integer integer);
    public Docente guardar(Docente objDocente);
    public List<Docente> listar();
}