package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Respuesta;


public interface GestionarRespuestaCUIntPort 
{
    public Respuesta crear(Respuesta objRespuesta);
    public List<Respuesta> listar();
}
