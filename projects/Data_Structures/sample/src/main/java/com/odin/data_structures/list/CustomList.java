
package com.odin.data_structures.list;


/**
 *
 * @author JuanCarlosEspinozaZu
 */
public interface CustomList<Entity extends Object> extends Iterable<Entity> {
    
   /**
    * Returns {@code true} if the element exist in the list 
    * @param e Element of type E to look for in the list
    * @return {@code true} if this list contains the specified element 
    */
    boolean contains (Entity e );
    
    
    
    
}
