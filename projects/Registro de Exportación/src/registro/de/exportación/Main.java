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
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class Main {

    private static boolean isActivo = true;
    private static Scanner scanner = new Scanner(System.in);


    private static RepositorioDeClientes Clientes = new RepositorioDeClientesImpl();
    private static RepositorioDeExportaciones Exportaciones = new RepositorioDeExportacionesImpl();
    private static ConversorDePesos Conversor = new ConversorDePesosImpl();

    private static ServicioDeExportaciones Servicio = new ServicioDeExportacionesImpl(Clientes, Exportaciones, Conversor);
    
    public static void main(String[] args) {

        try {
            //MostrarMenu();
           
            
           Clientes.Agregar(new Cliente("504020630", "Default CLiente", "juan-4002@hotmail.com"));
           
           Exportacion exp1 = new Exportacion( TipoExportacion.ECP ,"Costa Rica", TipoServicio.AVION,895.55);
           Exportacion exp2 = new Exportacion( TipoExportacion.ECS ,"Estados Unidos", TipoServicio.BARCO,895.55);

           Clientes.ObtenerTodos().get(0).AsignarExportacion(exp2);
           Clientes.ObtenerTodos().get(0).AsignarExportacion(exp1);
           
           exp1.AsignarCliente(Clientes.ObtenerTodos().get(0));
           exp2.AsignarCliente(Clientes.ObtenerTodos().get(0));
           
           Exportaciones.Agregar(exp1);
           Exportaciones.Agregar(exp2);
           
           java.awt.EventQueue.invokeLater(() -> new Layout(Servicio,Clientes,  Exportaciones ).setVisible(true));

        } catch (Exception ex) {

            System.err.printf("Error %s\n " + ex.getMessage());
        }
    }

    /////STstic methods to menu
    static void MostrarMenu() throws IOException {

        try {

             System.out.println(""
                        + "##############  Registro de Exportacion   ################################");
            while (isActivo) {

               
                System.out.println("Por favor selecione una opcion del menu:\n"
                        + "1. Crear una exportacion\n"
                        + "2. Reporte General\n"
                        + "3. Reporte Agrupado\n"
                        + "4. Salir del sistema");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        OpcionesMenu.CrearExportacion();
                        break;
                    case 2:
                      // Reporte general
                        OpcionesMenu.MostrarReporteGeneral();
                        break;

                    case 3:
                        OpcionesMenu.MostrarReporteagrupado();
                        break;

                    //Reporte Agrupado
                    case 4:
                        System.out.println("Adios!");
                        isActivo = false;
                        break;
                    default:
                      System.out.println("Opcion no valida, por favor ingrese un valor entre 1 y 4:\n");
                        break;
                }

            }

        } catch (Exception ex) {
            System.err.printf("Error %s\n" + ex.getMessage());
        }
    }

}
