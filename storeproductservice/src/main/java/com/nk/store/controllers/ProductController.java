package com.nk.store.controllers;

import com.nk.store.Mapper.Mapper;
import com.nk.store.dtos.ResponseProductDto;
import com.nk.store.models.Product;
import com.nk.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addNewProduct")
    public ResponseEntity<Map<String, String>> addNewProduct(
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("image") MultipartFile imageFile) {

        Map<String, String> response = new HashMap<>();
        try {
            productService.saveProduct(name, price, imageFile);
            response.put("message", "Product uploaded successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (IOException e) {
            response.put("message", "Failed to upload product.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ResponseProductDto>> getAllProduct(){

        List<Product> products = productService.getAllProduct();

        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .body(Mapper.toResponseProductgDtoList(products));

    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDto> getSingleProduct(@PathVariable Long id) {
        Optional<Product> productEntity = productService.getProductById(id);
//        if (productEntity.isPresent()) {
//
//
//            // Return the DTO with status OK
//            return ResponseEntity.ok()
//                    .contentType(org.springframework.http.MediaType.APPLICATION_JSON)  // Use JSON for the whole product entity
//                    .body(Mapper.toResponseProductDto(productEntity.get()));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
        return productEntity.map(product -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)  // Use JSON for the whole product entity
                .body(Mapper.toResponseProductDto(product))).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<byte[]> getProductImage(@PathVariable Long id) {
//        Optional<Product> productEntity = productService.getProductById(id);
//
//        if (productEntity.isPresent() && productEntity.get().getImage() != null) {
//            return ResponseEntity.ok()
//                    .contentType(org.springframework.http.MediaType.IMAGE_JPEG)  // or IMAGE_PNG based on your use case
//                    .body(productEntity.get().getImage());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
}
