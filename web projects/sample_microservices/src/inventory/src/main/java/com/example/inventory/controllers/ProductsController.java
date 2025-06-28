package com.example.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.inventory.models.Product;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    @Autowired
    private RestTemplate template;

    private final List<Product> repository;

    public ProductsController(List<Product> products){
        this.repository = products;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductsResponse>> getAll(@RequestParam(required=false) String id) {

        try {

            List<ProductsResponse> products = repository.stream()
                .filter(p -> id == null ||  p.getId().equals(id))
                .map(p -> new ProductsResponse(p.getId(), p.getName(), p.getQuantity())).toList();

            return ResponseEntity.ok(products);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();

        }

    }

    public static class ProductsResponse {

        private String Id;
        private String Name;
        private int Quantity;

        public ProductsResponse(String id, String name, int quant) {

            this.Id = id;
            this.Name = name;
            this.Quantity = quant;
        }

        public String getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }

        public int getQuantity() {
            return Quantity;
        }
    }

}
