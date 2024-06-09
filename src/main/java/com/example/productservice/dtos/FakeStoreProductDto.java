package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto {

        private Long id;
        private String title;
        private double price;
        private String category;
        private String description;
        private String image;

        public Product convertDtotoProduct(FakeStoreProductDto dto){
                Product product = new Product();
                product.setId(dto.getId());
                product.setTitle(dto.getTitle());
                product.setPrice(dto.getPrice());
                product.setDescription(dto.getDescription());
               // product.setCategory(dto.getCategory());
                // Assuming you don't need to convert the image field as it's not present in Product class
                return product;
        }
    }
