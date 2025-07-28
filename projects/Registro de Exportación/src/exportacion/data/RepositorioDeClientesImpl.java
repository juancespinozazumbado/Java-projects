package exportacion.data;

import exportacion.models.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class RepositorioDeClientesImpl extends RepositorioGenericoImpl<Cliente> implements RepositorioDeClientes, Serializable {
    
    public RepositorioDeClientesImpl(){
        super();
    }

    @Override
    public Cliente ObtenerPorCedula(String cedula) {
        
        for(Cliente cliente : this.Entidades){
            if(cliente.getIdCliente().equals(cedula)){
                return cliente;
            }
        }
        return null;
    }
    
}
