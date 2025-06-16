package exportacion.validators;

import exportacion.exceptions.CustomValidacionException;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class ValidadorNombre {

    public static void ValidarNomnbre(String nombre) throws CustomValidacionException {

        String nombreSinEspcios = nombre.trim();

        if (nombreSinEspcios.length() < 7) {
            throw new CustomValidacionException("El nombre debe contener al menos 7 caracteres");
        }

        int numPalabras = ContarPalabras(nombreSinEspcios);
        if (numPalabras < 3) {
            throw new CustomValidacionException("El nombre debe estar compuesto de tres palabras: Nombre + Apellido1 + Apellido 2");
        }

    }

    ////// Metodo para contar palabras en el nombre
    
     private static int ContarPalabras(String entrada) {
        int cuenta = 0;
        boolean noVacio = false;
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == ' ') {
                if (noVacio) {
                    cuenta++;
                    noVacio = false;
                }
            } else {
                noVacio = true;
            }
        }
        if (noVacio) {
            cuenta++;
        }
        return cuenta;
    }

}
