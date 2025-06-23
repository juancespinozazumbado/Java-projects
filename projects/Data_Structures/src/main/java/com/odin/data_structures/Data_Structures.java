package com.odin.data_structures;

import java.util.ArrayList;
import java.util.List;

import com.odin.data_structures.list.CustomList;
import com.odin.data_structures.list.ListImpl;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class Data_Structures {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        CustomList<Object> list = new ListImpl<Object>();
        List<Object> list2 = new ArrayList<Object>();
        
        System.out.println("Contian the element: " + (list.contains("Hello")));
    }
}
