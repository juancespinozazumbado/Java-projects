package com.example.orders.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrdersController{

    @GetMapping("/")
    public String get(){
        return "Hellow from order service";
    }

    @GetMapping("/status/{id}")
    public String getStatus(@PathVariable String id){
        return "id";
    }


    public static class ResponseEntity<T>{

        

    }


}
