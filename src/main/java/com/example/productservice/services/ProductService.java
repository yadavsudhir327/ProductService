package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(long id);


}
