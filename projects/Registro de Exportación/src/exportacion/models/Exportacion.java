package exportacion.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class Exportacion extends EntidadBase implements Serializable {

    private TipoExportacion Tipo_Exportacion;
    private LocalDateTime Fecha_Exportacion;
    private String Zona_Envio;
    private TipoServicio Tipo_Servicio;
    private double Kilogramos_Embarcar;
    private double Costo_por_Exportacion;
    private String IdCliente;
    private Cliente Cliente;

    public Exportacion() {
        super();
        this.Fecha_Exportacion = LocalDateTime.now();
    }
    
    public Exportacion( TipoExportacion tipoExportacion, String ZonaEnvio,TipoServicio tipoServicio, double kilos_embalar ){
        
 
        this.Tipo_Exportacion = tipoExportacion;
        this.Fecha_Exportacion = this.Fecha_Exportacion = LocalDateTime.now();
        this.Kilogramos_Embarcar = kilos_embalar; 
        this.Tipo_Servicio = tipoServicio; 
        this.Zona_Envio = ZonaEnvio; 
        this.Costo_por_Exportacion = 0;
        
        //Asigna el costo total de la exportacion
        calcularCostoTotalExportacion();
        
    }
    
    private void calcularCostoTotalExportacion(){
        
        double total = 0; 
        
        if(this.Tipo_Servicio == Tipo_Servicio.BARCO){
            this.Costo_por_Exportacion = this.Kilogramos_Embarcar * 150;
        }else {
            this.Costo_por_Exportacion = this.Kilogramos_Embarcar * 450;
        }
        
    }
    
   
    
//################ Settters & Geters ###########################################
    
       public String getIdCLiente() {
        return this.IdCliente;
    }

    public void setIdCliente(String idCliente) {
        this.IdCliente = idCliente;
    }
    
    public TipoExportacion getTipo_Exportacion() {
        return Tipo_Exportacion;
    }

    public void setTipo_Exportacion(TipoExportacion Tipo_Exportacion) {
        this.Tipo_Exportacion = Tipo_Exportacion;
    }

    public LocalDateTime getFecha_Exportacion() {
        return Fecha_Exportacion;
    }

    public String getZona_Envio() {
        return Zona_Envio;
    }

    public void setZona_Envio(String Zona_Envio) {
        this.Zona_Envio = Zona_Envio;
    }

    public TipoServicio getTipo_Servicio() {
        return Tipo_Servicio;
    }

    public void setTipo_Servicio(TipoServicio Tipo_Servicio) {
        this.Tipo_Servicio = Tipo_Servicio;
    }

    public double getKilogramos_Embarcar() {
        return Kilogramos_Embarcar;
    }

    public void setKilogramos_Embarcar(double Kilogramos_Embarcar) {
        this.Kilogramos_Embarcar = Kilogramos_Embarcar;
    }

    public double getCosto_por_Exportacion() {
        return Costo_por_Exportacion;
    }
    
    public Cliente getCliente(){
        return this.Cliente;
    }
    
    public void AsignarCliente(Cliente cliente){
        this.Cliente = cliente;
        this.IdCliente = this.Cliente.getIdCliente();
    }


}
