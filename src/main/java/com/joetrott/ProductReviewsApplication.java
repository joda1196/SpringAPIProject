package com.joetrott;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductReviewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductReviewsApplication.class, args);
    }
}
