package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.DocenteFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort
{
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final DocenteFormateadorResultadosIntPort objDocenteFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, DocenteFormateadorResultadosIntPort objDocenteFormateadorResultados)
    {
        this.objDocenteFormateadorResultados = objDocenteFormateadorResultados;
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
    }

    @Override
    public Docente crear(Docente objDocente) 
    {
        Docente objDocenteCreado = null;
        if (this.objGestionarDocenteGateway.existeUsuarioPorCodigo(objDocente.getIdpersona())) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un docente con el codigo");
        } else {

            
                objDocenteCreado = this.objGestionarDocenteGateway.guardar(objDocente);
            
        }
        return objDocenteCreado;
        
    }

    @Override
    public List<Docente> listar() 
    {
        List<Docente> listaObtenida = objGestionarDocenteGateway.listar();
        return listaObtenida;
    }
    
}
