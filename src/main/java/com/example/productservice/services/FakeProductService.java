package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
      return dto!=null?Product.convertDtoToProduct(dto):null;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto []dtos=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product>products=new ArrayList<>();
        for(FakeStoreProductDto dto:dtos){
            products.add(Product.convertDtoToProduct(dto));
        }
        return products;
    }


    @Override
    public Product addProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = FakeStoreProductDto.convertProductToDto(product);
        fakeStoreProductDto =
                restTemplate
                        .postForObject("https://fakestoreapi.com/products/", fakeStoreProductDto, FakeStoreProductDto.class);
        return Product.convertDtoToProduct(fakeStoreProductDto);
    }
    @Override
    public Product updateProduct(Product product,long id) {
        FakeStoreProductDto fakeStoreProductDto= FakeStoreProductDto.convertProductToDto(product);
        fakeStoreProductDto=restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,fakeStoreProductDto, FakeStoreProductDto.class);
        return Product.convertDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public boolean deleteProduct(long id) {
        try{
            restTemplate.delete("https://fakestoreapi.com/products/"+id);
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
}
