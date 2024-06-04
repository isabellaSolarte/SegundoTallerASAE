package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Cuestionario;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.TipoPregunta;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.ExcepcionFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarCuestionarioGatewayIntPort;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort
{

    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final ExcepcionFormateadorResultadosIntPort objCuestionarioFormateadorResultados;

    public GestionarCuestionarioCUAdapter(GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway, ExcepcionFormateadorResultadosIntPort objCuestionarioFormateadorResultados){
        this.objCuestionarioFormateadorResultados = objCuestionarioFormateadorResultados;
        this.objGestionarCuestionarioGateway = objGestionarCuestionarioGateway;
    }
    @Override
    public Cuestionario crear(Cuestionario objCuestionario) {
        Cuestionario objCuestionarioCreado = null;
        if (this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(objCuestionario.getTitulo())) {
            this.objCuestionarioFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un cuestionario con el titulo");
        } else {
            objCuestionarioCreado = this.objGestionarCuestionarioGateway.guardar(objCuestionario);
        }
        return objCuestionarioCreado;
    }

    @Override
    public List<Cuestionario> listar() {
        List<Cuestionario> listaObtenida = objGestionarCuestionarioGateway.listar();
        return listaObtenida;
    }
    @Override
    public List<TipoPregunta> listaTipoPreguntas() {
        return this.objGestionarCuestionarioGateway.listaTipoPreguntas();
    }
  
    
}
