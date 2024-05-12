package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException 
{

  protected CodigoError codigoError;

  public abstract String formatException();
}
