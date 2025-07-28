
package exportacion.usecases;

import exportacion.models.Cliente;
import exportacion.models.Exportacion;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface ServicioDeExportaciones {
    
    public boolean CrearExportacion(Cliente cliente, Exportacion exportacion);
    public boolean CrearCliente(Cliente cliente);

}
