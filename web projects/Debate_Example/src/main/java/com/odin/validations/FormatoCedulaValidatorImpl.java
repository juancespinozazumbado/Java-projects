/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.odin.validations;

import com.odin.exceptions.FormatoCedulaInvalidoException;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class FormatoCedulaValidatorImpl extends ValidadorImpl implements FormatoCedulaValidator{

    private final Logger logger = Logger.getLogger("logger");

    @Override
    public boolean ValidateCedula(String cedula) throws FormatoCedulaInvalidoException {

        try {

            if (cedula == null || cedula.length() != 9) {
                throw new FormatoCedulaInvalidoException("La cedula no tiene el tamaño correcto");
            }

            if (cedula.charAt(1) != '-' || cedula.charAt(6) != '-') {
                throw new FormatoCedulaInvalidoException("La cedula no tiene el formato correcto. Debe contener guimes entre los tramos, ejemplo 0-000-000");
            }

            // Check positions 2-5 are digits (indices 2 to 5)
            for (int i = 2; i <= 5; i++) {
                if (!Character.isDigit(cedula.charAt(i))) {
                    throw new FormatoCedulaInvalidoException("La cedula no debe contener cracateres en el tramo 0-000-0000");
                }
            }


            return true;

        } catch (Exception ex) {
            logger.log(java.util.logging.Level.WARNING, "", ex);
            return false;
        }
    }



}
