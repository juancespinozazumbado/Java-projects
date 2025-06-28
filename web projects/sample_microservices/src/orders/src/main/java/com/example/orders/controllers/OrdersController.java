package com.example.orders.controllers;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/v1/orders")
// @Slf4j
public class OrdersController {

    private final RestTemplate resttemplate;
    // private final String baseUrl;

    // @Value("${APP_MAX_COUNT}")
    // private int MaxCount;
    @Value("${INVENTORY_BASE_URL}")
    private String inventoryBaseUrl;

   Logger logger =  LoggerFactory.getLogger(OrdersController.class);

    /*, @Value("${INVENTORY_BASE_URL}") String baseUrl */
    public OrdersController(RestTemplate template) {

        //  this.baseUrl = baseUrl; 
        this.resttemplate = template;
    }

    @GetMapping("/")
    public String get(){
        return "Hellow from order service";
    }



    @GetMapping("/status")
    public ResponseEntity<ProductStatusResponse> getStatus(@RequestParam String id){

        try{
            
            //String Url = "http://localhost:8081"+ "/v1/products/?id="+ id;
            //String Url = inventoryBaseUrl + "/v1/products/?id=" + id;

            logger.warn("Base URL"+ inventoryBaseUrl);

            URI Url = UriComponentsBuilder
                    .fromHttpUrl(inventoryBaseUrl)
                    .path("/v1/products")
                    .queryParam("id", id)
                    .build()
                    .encode()
                    .toUri();

            logger.info("the result URI: " + Url);   
            logger.info("Controller logs");   
            logger.info(id);  

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // HttpEntity<Object> requestEntity = new HttpEntity<>(null, headers);

            List<GetProductResponse> response = resttemplate.exchange(
                Url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GetProductResponse>>() {}
            ).getBody();


            if(response != null && !response.isEmpty())
                return ResponseEntity.ok().body(new ProductStatusResponse(response.get(0).getName(),  "SUCCESS"));
            else
               return ResponseEntity.ok(new ProductStatusResponse(id, "invalid: object not found."));
               // return ResponseEntity.notFound().build();

        }catch(Exception ex){


            return ResponseEntity.ok(new ProductStatusResponse(id, "problem:", ex));

        }
            
    }

    @PostMapping("/")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
  
    public static class GetProductResponse{

        private String id; 
        private String name;
        private int quantity; 

        public GetProductResponse(String Id, String Name, int quant){

            this.id = Id;
            this.name = Name;
            this.quantity = quant;
        }

        public String getId() {return id;}
        public String getName(){ return name;}
        public int getQUantity(){return quantity;}

    }

    public static class ProductStatusResponse{

        public String Id; 
        public String Status;
        public Object Error;

        public ProductStatusResponse(String Id, String status){

            this.Id = Id; 
            this.Status = status;
  

        }
        public ProductStatusResponse(String Id, String status, Object Error){

            this.Id = Id; 
            this.Status = status;
            this.Error = Error;

        }

    }


}
