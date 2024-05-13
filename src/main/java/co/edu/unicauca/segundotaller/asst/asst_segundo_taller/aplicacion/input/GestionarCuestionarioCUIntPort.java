package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioCUIntPort {
    public Cuestionario crear(Cuestionario objCuestionario);
    public List<Cuestionario> listar();

}
