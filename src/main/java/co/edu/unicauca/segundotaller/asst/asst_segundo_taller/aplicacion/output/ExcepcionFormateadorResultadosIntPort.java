package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.aplicacion.output;

public interface ExcepcionFormateadorResultadosIntPort 
{
    public void retornarRespuestaErrorEntidadExiste(String mensaje);
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
    public void retornarDocenteNoExiste(String mensaje);
}