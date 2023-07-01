package com.joetrott.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository repository) {
        return args -> {
            Product product1 = new Product("Iphone 14", "Great Phone", 750.0);
            Product product2 = new Product("Nintendo Switch", "The latest console release from Nintendo", 300.0);
            Product product3 = new Product("Oakley Mens Gold", "The Standard for Sunglasses", 150.0);
            Product product4 = new Product("Oakley Womens Rose", "The Standard for Womens' Sunglasses", 150.0);
            Product product5 = new Product("Nalgene 32oz Water Bottle", "Environment friendly water bottle fully recyclable", 9.75);

            repository.saveAll(
                    List.of(product1, product2, product3, product4, product5)
            );
        };
    }
}
