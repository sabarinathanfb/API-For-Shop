package com.nk.store.services;


import com.nk.store.models.Product;
import com.nk.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(String name, Double price, MultipartFile imageFile) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setImage(imageFile.getBytes());
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProduct(){

        return productRepository.findAll();

    }
}
