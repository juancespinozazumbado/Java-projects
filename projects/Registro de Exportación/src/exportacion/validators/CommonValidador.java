package exportacion.validators;

import exportacion.exceptions.CustomValidacionException;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class CommonValidador {

    public static void ValidarStringNulloVacio(String entrada) throws CustomValidacionException {

        if (entrada == null) {
            // 
            throw new CustomValidacionException("El nombre no puede ser Null");
        }

        if (entrada == null || entrada.isBlank()) {
            throw new CustomValidacionException("El Valor Nombre no debe ir vacio.");
        }
       
    }

    public static void ValidarSoloCaracteres(String entrada) throws CustomValidacionException {

        for (char c : entrada.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new CustomValidacionException("El valor nombre completo no debe ser Numerico.");
            }
        }

    }
    


    /// Validar que se ingrese unicamente dos opciones 1 o 2 
    
    public static void ValidarDosOpciones(int tipo) throws CustomValidacionException {

        if (tipo == 1 || tipo == 2) {
            return;

        }
        throw new CustomValidacionException("Por favor debe ingresar unicamente opciones 1 o 2");

    }

    public static void ValidarNegativos(double input) throws CustomValidacionException {

        if (input < 0) {
            throw new CustomValidacionException("El valor Kilogramos debe ser un umero mayor a 0 ");
        }

    }

}
