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

        public static FakeStoreProductDto convertProductToDto(Product product) {
                FakeStoreProductDto dto = new FakeStoreProductDto();
                dto.setId(product.getId());
                dto.setTitle(product.getTitle());
                dto.setPrice(product.getPrice());
                dto.setDescription(product.getDescription());
                if (product.getCategory() != null) {
                        dto.setCategory(product.getCategory().getTitle());
                }
                // Set other fields as needed
                return dto;
        }
}