package com.example.inventory;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.inventory.models.Product;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public List<Product> productsList(){

        List<Product> products = List.of(
            new Product("Bavaria"), 
            new Product("Imperial"), 
            new Product("Cacique")
        );

        return products;
        
    }

    
    
}


