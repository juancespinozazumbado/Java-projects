/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.odin.validations;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class ValidadorImpl implements Validador{

    @Override
    public boolean ValidarNullOVacios(String valor) throws Exception {
       if(valor == null){
           throw new Exception("El valor ingresado no puede ser null");
       }
       
       if(valor.length() == 0){
           throw new Exception("El valor no debe estar vacio");
       }
       
       return true;
    }

    @Override
    public boolean ValidarSoloNumeros(String valor) throws Exception {
        
        for(int i =0; i<= valor.length(); i++){
            if(!Character.isDigit(valor.charAt(i))){
                throw new Exception("El valor no debe contener caracteres");
            }
        }
        return true;
    }
    @Override
    public boolean ValidarNegativos(int valor) throws Exception {
       
        if(valor < 0){
            throw new Exception("El valor no debe ser negativo");
        }
        return true;
    }
    
}
