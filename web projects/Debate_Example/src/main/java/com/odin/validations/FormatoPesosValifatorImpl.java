/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.odin.validations;

import com.odin.exceptions.LimitePesoMaximoExcedidoException;
import java.util.logging.Logger;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class FormatoPesosValifatorImpl extends ValidadorImpl implements FormatoPesosValifator{
    
    private final int LIMITE_PESO_MAXIMO = 1000;
    private final Logger logger = Logger.getLogger("logger");

    @Override
    public boolean validarLimitePesoMaximo(int valor) throws LimitePesoMaximoExcedidoException {
        
        if(valor > LIMITE_PESO_MAXIMO){
            throw new LimitePesoMaximoExcedidoException("El valor supera el maximo permitido: 10000 KG");
        }
        return true;
        
    }
   
    
}
