/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.odin.validations;

import com.odin.exceptions.LimitePesoMaximoExcedidoException;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface FormatoPesosValifator extends Validador {
    
    public boolean validarLimitePesoMaximo(int valor) throws LimitePesoMaximoExcedidoException ;
    
}
