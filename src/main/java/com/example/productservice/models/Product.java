package com.example.productservice.models;

import com.example.productservice.dtos.FakeStoreProductDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private double price;
    private String description;
    private Category category;

    public static Product convertDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        // Assuming you have a method in Product class to set Category
        Category category = new Category();
        category.setTitle(dto.getCategory());
        product.setCategory(category);
        // Set other fields as needed
        return product;
    }
}