package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.ExcepcionFormateadorResultadosIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort
{
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final ExcepcionFormateadorResultadosIntPort objDocenteFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, ExcepcionFormateadorResultadosIntPort objDocenteFormateadorResultados)
    {
        this.objDocenteFormateadorResultados = objDocenteFormateadorResultados;
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
    }

    @Override
    public Docente crear(Docente objDocente) 
    {
        Docente objDocenteCreado = null;
        if (this.objGestionarDocenteGateway.existeUsuarioPorId(objDocente.getIdPersona())) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un docente con el codigo");
        } else {
            if(this.objGestionarDocenteGateway.existeUsuarioPorCodigo(objDocente.getNumeroIdentificacion())){
                this.objDocenteFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, la identificacion ya existe");
            }
            
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

    @Override
    public Docente buscarPorId(Integer id) {
        if(!this.objGestionarDocenteGateway.existeUsuarioPorId(id)){
            this.objDocenteFormateadorResultados.retornarDocenteNoExiste("Error, no se encuentra en el sistema un docente con el codigo");
        }
        return this.objGestionarDocenteGateway.buscarPorId(id);
    }
    
}
