
package exportacion.data;

import exportacion.models.Exportacion;
import exportacion.models.TipoExportacion;
import exportacion.models.TipoServicio;
import java.util.List;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface RepositorioDeExportaciones extends RepositorioGenerico<Exportacion>{
    
    public List<Exportacion> FiltrarPorTipo(TipoExportacion tipo);
    public List<Exportacion> FiltrarPorCliente(String clienteId);
    
}
