package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;


public interface GestionarCuestionarioGatewayIntPort {
    public boolean existeCuestionarioPorTitulo(String tituloCuestionario);
    public Cuestionario guardar(Cuestionario objCuestionario);
    public List<Cuestionario> listar();
    
} 