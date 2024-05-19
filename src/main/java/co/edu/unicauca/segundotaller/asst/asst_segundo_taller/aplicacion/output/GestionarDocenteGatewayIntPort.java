package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort 
{
    public boolean existeUsuarioPorId(Integer integer);
    public boolean existeUsuarioPorCodigo(String id);
    public Docente guardar(Docente objDocente);
    public List<Docente> listar();
    public Docente buscarPorId(Integer id);
}