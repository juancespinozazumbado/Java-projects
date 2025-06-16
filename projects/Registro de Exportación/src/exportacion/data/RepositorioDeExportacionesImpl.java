
package exportacion.data;

import exportacion.models.Exportacion;
import exportacion.models.TipoExportacion;
import exportacion.models.TipoServicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class RepositorioDeExportacionesImpl extends RepositorioGenericoImpl<Exportacion> implements RepositorioDeExportaciones {
    
    public RepositorioDeExportacionesImpl(){
        super();
    }
    

    @Override
    public List<Exportacion> FiltrarPorTipo(TipoExportacion tipo) {
      
          List<Exportacion> exportaciones = new ArrayList<Exportacion>();
        
        for(Exportacion exportacion : this.Entidades){
            
            if(exportacion.getTipo_Exportacion() == tipo){
                exportaciones.add(exportacion);
            }
        }
        return exportaciones;
    }

    @Override
    public List<Exportacion> FiltrarPorCliente(String clienteId) {
        
        List<Exportacion> exportaciones = new ArrayList<Exportacion>();
        
        for(Exportacion exportacion : this.Entidades){
            
            if(exportacion.getIdCLiente().equals(clienteId)){
                exportaciones.add(exportacion);
            }
        }
        return exportaciones;
        
    }
    
}
