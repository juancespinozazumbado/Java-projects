/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.datastructures.collections;

import java.util.Iterator;

/**
 *
 * @author JuanCarlosEspinozaZu
 * @param <E>
 */
public interface Collection<E> extends Iterable<E>{
    
    public int size();
    public boolean isEmpty();
    public boolean contains(Object element);
    public boolean add(E element);
    public boolean remove(E element);
    
    public E[] toArray();
    public <T> T[] toArray(T[] array);
    
    public boolean addAll(Collection<E> elements);
    public boolean removeAll(Collection<E> elements);
    public boolean containsAll(Collection<E> elements);
    public boolean clear();
    
    public Iterator<E> iterator();
}
