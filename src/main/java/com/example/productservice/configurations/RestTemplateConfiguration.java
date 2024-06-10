package com.example.productservice.configurations;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    //Why do u need the builder class here
    public RestTemplate restTemplate() { return  new RestTemplateBuilder().build();}
}
