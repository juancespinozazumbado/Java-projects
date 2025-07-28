
package exportacion.utils;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 *
 * @author JuanCarlosEspinozaZu
 * 
 * Se reviso la seccion 10. Programación orientada a objetos: polimorfismo e interfaces del libro
 * en la pagina 397 se menciona el uso de clases y metodos estaticos para evitar la instancicion de clases
 * 
 * Esto es util si tenemos metodos de ayuda utilitarios que se usan en ejecucion, pero unicamente ejecutan una logica rapida.
 * Tambien se usa este patron en las clases Validador que son Objetos que unicamente tienen como funcion validar reglas de negocio
 * 
 */
public class CustomUtils implements Serializable {

    private static final DateTimeFormatter FORMATO_FECHA
            =  DateTimeFormatter.ofPattern("dd MMM uuuu : hh:mm a", Locale.ENGLISH);

    public static String formatLocalDateTime(LocalDateTime dt) {
        return dt.format(FORMATO_FECHA);
    }
    
    
    public static String MontosDecimalFormateador(double input){
        
        NumberFormat formateador = NumberFormat.getNumberInstance(Locale.GERMAN);
        return formateador.format(input);
        
    }

}
