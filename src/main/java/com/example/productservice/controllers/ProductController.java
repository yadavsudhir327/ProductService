package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
    return productService.getProductById(id);
    }
    @GetMapping
    public List<Product> GetAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping
    public  Product CreateProduct( @RequestBody Product product){
         return productService.addProduct(product);
    }

    @PatchMapping("/{id}")
    public  Product UpdateProduct( @RequestBody Product product,@PathVariable long id){
        return productService.updateProduct(product,id);
    }
    @DeleteMapping("/{id}")
    public  boolean DeleteProduct( @PathVariable("id")long id){

        return productService.deleteProduct(id);
    }
}
