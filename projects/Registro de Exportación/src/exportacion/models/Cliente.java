package exportacion.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Juan Carlos Espinoza Zumbado
 * UNED Programacion intermedia
 * II perido 2025 
 */
public class Cliente extends EntidadBase {
    
    private String Id_Cliente; 
    private String Nombre_Completo;
    private List<Exportacion> Exportaciones;

    
    public Cliente(String id, String nombre_completo){
        super();
        this.Exportaciones = new ArrayList<Exportacion>();
        this.Id_Cliente = id; 
        this.Nombre_Completo = nombre_completo; 
    }
    
    
    
//################ Settters & Geters ###########################################
    public String getIdCliente(){
        return this.Id_Cliente;
    }

    public String getNombre_Completo() {
        return Nombre_Completo;
    }

    public void setNombre_Completo(String Nombre_Completo) {
        this.Nombre_Completo = Nombre_Completo;
    }
    
    public List<Exportacion> getExportaciones(){
        return this.Exportaciones;
    }
    
    public void AsignarExportacion(Exportacion exportacion){
        
        this.Exportaciones.add(exportacion);
        
    }
}

