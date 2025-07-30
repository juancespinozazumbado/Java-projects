/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.odin.debate_example;

import com.odin.exceptions.FormatoCedulaInvalidoException;
import com.odin.exceptions.LimitePesoMaximoExcedidoException;
import com.odin.validations.FormatoCedulaValidator;
import com.odin.validations.FormatoCedulaValidatorImpl;
import com.odin.validations.FormatoPesosValifator;
import com.odin.validations.FormatoPesosValifatorImpl;
import java.util.logging.Logger;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class Main {
    
    private static final FormatoCedulaValidator validadorCedula = new FormatoCedulaValidatorImpl();
    private static final FormatoPesosValifator validadorPesos = new FormatoPesosValifatorImpl() ;
     private static final Logger logger = Logger.getLogger("logger");

    public static void main(String[] args) {
        
        
        String invalidCedula = "504020630";
        String cedulaValida = "5-0402-0630";
        
        try{
            
           if(validadorCedula.ValidateCedula(invalidCedula)){
               System.out.print("Cedula Valida");
           }
           
           int peso = 15000;
           validadorPesos.validarLimitePesoMaximo(peso);
            
            
        }catch(FormatoCedulaInvalidoException ex){
            System.out.print("Cedula invalida"+ ex.getMessage());
            
        }catch(LimitePesoMaximoExcedidoException ex){
            
            logger.log(java.util.logging.Level.WARNING, "", ex);
            
        }catch(Exception ex){
             System.out.print("Cedula invalida"+ ex.getMessage());
        }
       
    }
}
