package com.store.UserService.services;


import com.store.UserService.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductDTO getProductById(Long productId) {
        String url = "http://localhost:8080/api/products/" + productId;
        return restTemplate.getForObject(url, ProductDTO.class);
    }
}

