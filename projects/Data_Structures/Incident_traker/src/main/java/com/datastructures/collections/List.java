/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.datastructures.collections;

import java.util.Comparator;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface List<E extends Object> extends Collection<E> {
    
    public E get(int index);
    public E getFirst();
    public boolean add(E element, int index);
    
    public boolean sort(Comparator<E> comparator);
    
    
    
    
    
}
