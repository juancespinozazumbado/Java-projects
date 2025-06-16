
package exportacion.validators;

import exportacion.exceptions.CustomValidacionException;
import java.util.Scanner;

/**
 *
 * @author JuanCarlosEspinozaZu

 *  FunctionalInterface :recurso consultado en https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html
 * la   anotacion @FunctionalInterface , que se usa para indicar que la interface a pasar como parametro es una Funcion o se intenta usar como una 
 * Function<T> en una funcion Lamda.
 * En este caso la pasamos como parametro en el metodo {_Type}ValidadorHandler como por ejemplo doubleValidadorHandler
 * el parametro ValidadorEntradaDouble es una funcion lambda y se define como ValidadorHandler(params, entrada -> <Validator> )
 * en este contexto le indicamos que el con el valor input se ejecutara la funcion o metodo que pasemos en la lambda
 * ejemplo: doubleValidadorHandler("", entrada -> func(input))
 * en la linea 48 de esta clase validador.validar(entrada); sera la funcion que definimos en la lambda como entrada. 
 * En este caso es uno de los CustomValidadores que se usan para validar los diferentes esenarios y Logica de negocio. 
 * La interface funcional debe tener el mismo tipo de retorno y el mismo parametro de entrada para que calse en la definicion de la lambda
 * en nuentro ejemplo ValidarNomnbre es un metodo ( lo que se usara como FunctionalInterface) que es void y que acepta de entrada un valor de Tipo String.
 * por ende su FunctionalInterface ValidadorEntradaSring es de tipo Void y acepta como paranetro un valor de Tipo String. 
 * 
 * 
 * Esta implementacion se investigo en el Libro del Curso en la seccion Lambdas ( pags 646 - 707) y en la documentacion oficial del api de Java  
 * https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html . 
 * 
 * La razon de investigar y usar esta funcionalidad fue que se pueden crear validadores Custom para muchos casos de uso que el negocio demande. 
 * lo cual en el esenario de una app que crezca con el tiempo o cambie constantemente sus validaciones es escalable pues reusa codigo.
 */
public class ValidadorHandler {
    
        private static Scanner scanner = new Scanner(System.in);
        
        public static String stringValidadorHandler(String mensaje, ValidadorEntradaSring validador) {
        while (true) {
            System.out.print(mensaje + " ");
           String entrada = scanner.nextLine();
            try {
                validador.validar(entrada);
                return entrada;
            } catch (CustomValidacionException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }

    public static int intValidadorHandler(String mensaje, ValidadorEntradaInt validador) {
        while (true) {
            System.out.print(mensaje + " ");
            try {
                int entrada = Integer.parseInt(scanner.nextLine());
                validador.validar(entrada);
                return entrada;
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: Debe ingresar un valor numerico valido.");
            } catch (CustomValidacionException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }

    public static double doubleValidadorHandler(String mensaje, ValidadorEntradaDouble validador) {
        while (true) {
            System.out.print(mensaje + " ");
            try {
                double entrada = Double.parseDouble(scanner.nextLine());
                validador.validar(entrada);
                return entrada;
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: Debe ingresar un valor numerico valido con o sin decimales.");
            } catch (CustomValidacionException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }

    

    // Functional interfaces for lambdas
    @FunctionalInterface
    public interface ValidadorEntradaSring {

        void validar(String input) throws CustomValidacionException;
    }

    @FunctionalInterface
    public interface ValidadorEntradaInt {

        void validar(int input) throws CustomValidacionException;
    }

    @FunctionalInterface
    public interface ValidadorEntradaDouble {

        void validar(double input) throws CustomValidacionException;
    }

}
    

