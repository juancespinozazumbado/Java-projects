/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.odin.debate_example;

import com.odin.exceptions.FormatoCedulaInvalidoException;
import com.odin.validations.FormatoCedulaValidator;
import com.odin.validations.FormatoCedulaValidatorImpl;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class Main {

    public static void main(String[] args) {
        
        
        String invalidCedula = "504020630";
        String cedulaValida = "5-0402-0630";
        
        try{
            
            FormatoCedulaValidator validador = new FormatoCedulaValidatorImpl();
            
           if(validador.ValidateCedula(invalidCedula)){
               System.out.print("Cedula Valida");
           }
            
            
        }catch(FormatoCedulaInvalidoException ex){
            System.out.print("Cedula invalida"+ ex.getMessage());
            
        }
    }
}
