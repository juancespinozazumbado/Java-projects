/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.odin.validations;

import com.odin.exceptions.FormatoCedulaInvalidoException;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface FormatoCedulaValidator {
    
    public boolean ValidateCedula(String cedula) throws FormatoCedulaInvalidoException;
    
}
