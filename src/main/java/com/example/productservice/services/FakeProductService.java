package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeProductService implements ProductService {

    private final  RestTemplate restTemplate;

    public FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) {
       FakeStoreProductDto dto= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
      return dto!=null?dto.convertDtotoProduct(dto):null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(long id) {
        return false;
    }
}
