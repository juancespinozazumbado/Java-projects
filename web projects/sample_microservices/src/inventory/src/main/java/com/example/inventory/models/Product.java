package com.example.inventory.models;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String Id;
    private String Name;
    private int Quantity;
    private int Stok;

    public Product(String name, int quantity){
        this.Id = UUID.randomUUID().toString();
        this.Name = name;
        this.Quantity = quantity;
        this.Stok = 0;
    }

    public Product(String name){
        this.Id =  UUID.randomUUID().toString();
        this.Name = name; 
    }

    
}
