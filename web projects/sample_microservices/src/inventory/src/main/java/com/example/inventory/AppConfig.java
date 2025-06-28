package com.example.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.example.inventory.models.Product;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, @Value("${ORDERS_BASE_URL}") String baseUrl){

        DefaultUriBuilderFactory fatory = new DefaultUriBuilderFactory(baseUrl);

        fatory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);

        return builder
            .uriTemplateHandler(fatory)
            .build();
        
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


