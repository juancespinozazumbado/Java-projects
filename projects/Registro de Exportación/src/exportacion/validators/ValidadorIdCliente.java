package exportacion.validators;

import exportacion.exceptions.CustomValidacionException;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class ValidadorIdCliente {
    
    /*
    
    Alg: validar que el tamaño es 11 caracteres 1-1111-1111
         validar que contiene guiones '-' en las pociones 1 y 6 del string 
         validar que los tres segmentos 1, 1111 y 1111 en 1-1111-1111 son numericos
    */

    public static void ValidarIdCliente(String cedula) throws CustomValidacionException {

        // Must be exactly 11 characters: 1-1111-1111
        if (cedula.length() != 11) {
            throw new CustomValidacionException("el formato del ID debe ser acorde a Costa Rica: 1-1111-1111"
                    + "\nPor favor ingrese con '-' y conjunto de 4 numeros");
        }

        // Los giones debn estar entre 1 y 6
        if (cedula.charAt(1) != '-' || cedula.charAt(6) != '-') {
            throw new CustomValidacionException("Debe ingresar el valor segun el formato (1-1111-1111).");
        }

        /// Descomponer la entrada en partes 1, 1111, 1111
        String parte1 = cedula.substring(0, 1);
        String parte2 = cedula.substring(2, 6);
        String parte3 = cedula.substring(7, 11);

        if (!SoloDigitos(parte1)) {
            throw new CustomValidacionException("La primera porcion debe tener valores numericos");
        }
        if (!SoloDigitos(parte2)) {
            throw new CustomValidacionException("La segunda porcion debe tener valores numericos.");
        }
        if (!SoloDigitos(parte3)) {
            throw new CustomValidacionException("La tercerea porcion debe tener valores numericos.");
        }
    }

    private static boolean SoloDigitos(String valor) {
        for (char caracter : valor.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                return false;
            }
        }
        return true;
    }

}
