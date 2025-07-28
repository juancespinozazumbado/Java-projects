package registro.de.exportación;

import exportacion.data.RepositorioDeClientes;
import exportacion.data.RepositorioDeClientesImpl;
import exportacion.data.RepositorioDeExportaciones;
import exportacion.data.RepositorioDeExportacionesImpl;
import exportacion.models.Cliente;
import exportacion.models.Exportacion;
import exportacion.models.TipoExportacion;
import exportacion.models.TipoServicio;
import exportacion.usecases.ServicioDeExportaciones;
import exportacion.usecases.ServicioDeExportacionesImpl;
import exportacion.utils.ConversorDePesos;
import exportacion.utils.ConversorDePesosImpl;
import exportacion.utils.CustomUtils;
import exportacion.validators.CommonValidador;
import exportacion.validators.ValidadorHandler;
import exportacion.validators.ValidadorIdCliente;
import exportacion.validators.ValidadorNombre;
import java.util.List;
import java.util.Scanner;

/**
 * @author JuanCarlosEspinozaZu
 * 
 * Toda la logica de la aplicacion esta en esta clase. 
 * 
 * En la clase main unicamente esta el menu de opciones. 
 * 
 * Las opciones se implementan aca
 */
public class OpcionesMenu {

    // private static boolean isActivo = true;
    private static Scanner scanner = new Scanner(System.in);

    private static RepositorioDeClientes Clientes = new RepositorioDeClientesImpl();
    private static RepositorioDeExportaciones Exportaciones = new RepositorioDeExportacionesImpl();
    private static ConversorDePesos Conversor = new ConversorDePesosImpl();

    private static ServicioDeExportaciones Servicio = new ServicioDeExportacionesImpl(Clientes, Exportaciones, Conversor);

    public static boolean CrearExportacion() {

        try {

            // captura datos del cliente
            System.out.println("Datos del cliente");
            String cedula = ValidadorHandler.stringValidadorHandler("Por favor ingrese el numero de identificacion:", entrada -> {
                CommonValidador.ValidarStringNulloVacio(entrada);
                ValidadorIdCliente.ValidarIdCliente(entrada);

            });

            String nombre = ValidadorHandler.stringValidadorHandler("Por favor ingrese el nombre completo:", entrada -> {
                CommonValidador.ValidarStringNulloVacio(entrada);
                CommonValidador.ValidarSoloCaracteres(entrada);
                ValidadorNombre.ValidarNomnbre(entrada);
            });

            // captura datos del cliente
            System.out.println("Datos de exportacion");

            int tipoExportacion = ValidadorHandler.intValidadorHandler("Por favor ingrese el Tipo de exportacion: \n"
                    + "1. 'ECP' Exportacion de Carga Pesada \n"
                    + "2. 'ECS' Exportacion de Carga Suelta.", entrada -> CommonValidador.ValidarDosOpciones(entrada));
            System.out.println("Tipo de exportacion seleccionad: " + (tipoExportacion == 1 ? TipoExportacion.ECP : TipoExportacion.ECS));

            int tipoServicio = ValidadorHandler.intValidadorHandler("Por favor ingrese el Tipo de Servicio: \n"
                    + "1. 'AVION'  \n"
                    + "2. 'BARCO'", entrada -> CommonValidador.ValidarDosOpciones(entrada));
            System.out.println("Tipo de Servicio seleccionad: " + (tipoServicio == 1 ? TipoServicio.AVION : TipoServicio.BARCO));

            String zonaEnvio = ValidadorHandler.stringValidadorHandler("Por favor ingrese el pais de envio", entrada -> {
                CommonValidador.ValidarStringNulloVacio(entrada);
                CommonValidador.ValidarSoloCaracteres(entrada);
            });

            double KilogramosAEmbracar = ValidadorHandler.doubleValidadorHandler("Por favor ingrese el valor de los Kilogramos a Embalar: \n",
                    entrada -> CommonValidador.ValidarNegativos(entrada));

            //Cliente cliente = new Cliente(cedula, nombre);

            Exportacion exportacion = new Exportacion(
              
                    (tipoExportacion == 1 ? TipoExportacion.ECP : TipoExportacion.ECS),
                    zonaEnvio,
                    (tipoServicio == 1 ? TipoServicio.AVION : TipoServicio.BARCO),
                    KilogramosAEmbracar
            );
            
           // exportacion.AsignarCliente(cliente);
            
          //  cliente.AsignarExportacion(exportacion);

           // Servicio.CrearExportacion(cliente, exportacion);

            System.out.println("Datos registrados exitosamente!");

        } catch (Exception ex) {
            return false;

        }
        return true;

    }

    public static void MostrarReporteGeneral() {

        try {
            //Servicio.CrearReporteGeneral();

            //Obtenemos los clientes del sistema
            List<Cliente> clientes = Clientes.ObtenerTodos();

            if (clientes.size() == 0) {

                System.out.println("**************** No Existen registros en el sistema aun ******************* ");
                return;
            }

            System.out.println("**************** Resumen de transaciones en el sistema ******************* ");

            for (Cliente cliente : clientes) {

                List<Exportacion> exportaciones = Exportaciones.FiltrarPorCliente(cliente.getIdCliente());

                for (Exportacion exportacion : exportaciones) {

                    System.out.println("Exportacion Numero:" + exportacion.GetId());
                    //System.out.println("||   Id Cliente   |   Nombre completo   |  Fecha de exportaxcion  |  Zona de Envio  |  Costo total   ||");
                    System.out.println("Id Cliente: " + cliente.getIdCliente());
                    System.out.println("Nombre completo: " + cliente.getNombre_Completo());
                    System.out.printf("Fecha de Exportacion: %s\n",  CustomUtils.formatLocalDateTime(exportacion.getFecha_Exportacion()));
                    System.out.println("Zona de Envio: " + exportacion.getZona_Envio());
                    System.out.println("Costo total de la Exportacion: " + "CRC " + CustomUtils.MontosDecimalFormateador(exportacion.getCosto_por_Exportacion()) + "\n");
                    System.out.println("**************** UL******************* " + "\n");

                }
            }

            return;

        } catch (Exception ex) {
            return;
        }
    }

    public static void MostrarReporteagrupado() {

        try {
            //Servicio.CrearReporteAgrupado();

            List<Exportacion> exportaciones = Exportaciones.ObtenerTodos();
            if (exportaciones.size() == 0) {

                System.out.println("**************** No Existen registros en el sistema aun ******************* ");
                return;
            }

            System.out.println("*******************Reporte Agrupado *****************" + "\n");

            MostrarSumatoriaDeCostosPorTipo(TipoExportacion.ECP);
            MostrarSumatoriaDeCostosPorTipo(TipoExportacion.ECS);

            return;

        } catch (Exception ex) {
            return;
        }
    }

    private static void MostrarSumatoriaDeCostosPorTipo(TipoExportacion tipo) {

        List<Exportacion> exportaciones = Exportaciones.FiltrarPorTipo(tipo);

        double sumatoriaCostos = 0.0;
        double totalKilos = 0.0;
        for (Exportacion exportacion : exportaciones) {

            sumatoriaCostos += exportacion.getCosto_por_Exportacion();
            totalKilos += exportacion.getKilogramos_Embarcar();
        }

        System.out.println("Sumarizacion de Costo Total de exportaciones " + tipo + " : " + "CRC " + CustomUtils.MontosDecimalFormateador(sumatoriaCostos));
        System.out.println("Total Kilogramos a embalar: " + CustomUtils.MontosDecimalFormateador(totalKilos) + "Kg");
        System.out.println("Total Libras a embalar: " + CustomUtils.MontosDecimalFormateador(Conversor.KilogramosALibras(totalKilos)) + "Lb");
        System.out.println("Total Gramos a embalar: " + CustomUtils.MontosDecimalFormateador(Conversor.KilogramosAGramos(totalKilos)) + "g");
        System.out.println("Total Toneladas a embalar: " + CustomUtils.MontosDecimalFormateador(Conversor.KilogramosAToneladas(totalKilos)) + "TM");
        System.out.println("*******************UL *****************" + "\n");

    }

}
