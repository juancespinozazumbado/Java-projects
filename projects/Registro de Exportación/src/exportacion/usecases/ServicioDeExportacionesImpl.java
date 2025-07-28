
package exportacion.usecases;

import exportacion.data.RepositorioDeClientes;
import exportacion.data.RepositorioDeExportaciones;
import exportacion.models.Cliente;
import exportacion.models.Exportacion;
import exportacion.utils.ConversorDePesos;
import java.util.logging.Level;
import registro.de.exportación.Layout;

/**
 *
 * @author JuanCarlosEspinozaZu
 * 
 *  Se investigo la seccion Programación orientada a objetos: polimorfismo e interfaces
 * paginas 361-407
 * 
 * 
 */
public class ServicioDeExportacionesImpl implements ServicioDeExportaciones {
    
    private final RepositorioDeClientes Clientes; 
    private final RepositorioDeExportaciones Exportaciones;
    private final ConversorDePesos Conversor;
     private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Layout.class.getName());

    public ServicioDeExportacionesImpl(RepositorioDeClientes clientes, RepositorioDeExportaciones exportaciones, ConversorDePesos conversor) {
        this.Exportaciones = exportaciones;
        this.Clientes = clientes;
        this.Conversor = conversor;
    }

    @Override
    public boolean CrearExportacion(Cliente cliente, Exportacion exportacion) {

        try {

            Cliente posibleCliente = Clientes.ObtenerPorCedula(cliente.getIdCliente());

            if (posibleCliente == null) {
                this.Clientes.Agregar(cliente);
                
                this.Exportaciones.Agregar(exportacion);
            } else {
                this.Exportaciones.Agregar(exportacion);
            }
            return true;

        } catch (Exception ex) {

            System.out.println("Excepcion presentada en Ingresar exportacion: " + ex.getMessage());
            return false;
        }

    }
    
    @Override
    public boolean CrearCliente(Cliente cliente){
        
        try{
            
            this.Clientes.Agregar(cliente);
            
            return true;
            
        }catch(Exception ex){
            
            logger.log(Level.SEVERE, ex.getMessage());
            return false;
            
        }    
    }
}

