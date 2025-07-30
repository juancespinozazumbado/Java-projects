/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.odin.validations;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface Validador {
    
    public boolean ValidarNullOVacios(String valor) throws Exception;
    
    public boolean ValidarSoloNumeros(String valor) throws Exception;
    
    public boolean ValidarNegativos(int valor) throws Exception;
    
    
}
