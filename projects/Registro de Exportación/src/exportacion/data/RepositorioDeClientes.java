package exportacion.data;

import exportacion.models.Cliente;
import java.util.List;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface RepositorioDeClientes extends RepositorioGenerico<Cliente> {
    
    public Cliente ObtenerPorCedula(String cedula);

    
}
