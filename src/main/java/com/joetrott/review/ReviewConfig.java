package com.joetrott.review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReviewConfig {
    @Bean
    CommandLineRunner reviewCommandLineRunner(ReviewRepository repository) {
        return args -> {
            Review review1 = new Review(3, "It's aight");
            Review review2 = new Review(1, "Non functioning on arrival");
            Review review3 = new Review(5, "LOVE IT");
            Review review4 = new Review(2, "Not gonna buy it again");
            Review review5 = new Review(3, "Great but broke after a month");
            Review review6 = new Review(4, "Very nice!");

            repository.saveAll(
                    List.of(review1, review2, review3, review4, review5, review6)
            );
        };
    }
}
