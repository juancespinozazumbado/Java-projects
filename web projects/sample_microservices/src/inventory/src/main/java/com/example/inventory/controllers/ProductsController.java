package com.example.inventory.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.inventory.models.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    @Autowired
    private RestTemplate template;

    @Value("${ENV}")
    String ENV;

    private final Logger logger =  LoggerFactory.getLogger(ProductsController.class);

    private final List<Product> repository;

    public ProductsController(List<Product> products) {
        this.repository = products;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductsResponse>> getAll(@RequestParam(required = false) String id) {

        try {

            List<ProductsResponse> products = repository.stream()
                    .filter(p -> id == null || p.getId().equals(id))
                    .map(p -> new ProductsResponse(p.getId(), p.getName(), p.getQuantity())).toList();

            return ResponseEntity.ok(products);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();

        }

    }

    @GetMapping("/ping")
    public ResponseEntity<CommonResponseEntity> Ping() {

        try {

            logger.info("Making ping to the Orders service from "+ ENV);

            String path = "/v1/orders/";

           String response = template.getForObject(path, String.class);

           if(response != null && !response.isEmpty()){

              return ResponseEntity.ok(new CommonResponseEntity(true, "Mesaage: " + response, null ));

           }else   return ResponseEntity.ok(new CommonResponseEntity(false, "canot ping orders service in env:" + ENV + " response: " + response, null ));

            
        } catch (Exception ex) {

            return ResponseEntity.badRequest().body(new CommonResponseEntity(false, "Errores", ex));
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

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter

    public static class CommonResponseEntity {

        boolean succes;
        String message;
        Object errors;

    }

}
