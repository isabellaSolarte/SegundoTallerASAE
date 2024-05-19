package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.ExcepcionFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
@Service
public class FomateadorResultadosImplAdapter implements ExcepcionFormateadorResultadosIntPort
{

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }

    @Override
    public void retornarDocenteNoExiste(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarDocenteNoExiste'");
    }
    
}
