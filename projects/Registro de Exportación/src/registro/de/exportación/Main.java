package registro.de.exportación;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class Main {

    private static boolean isActivo = true;
    private static Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) {

        try {
            MostrarMenu();

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
