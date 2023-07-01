package com.joetrott.category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {
    @Bean
    CommandLineRunner categoryCommandLineRunner(CategoryRepository repository) {
        return args -> {
            Category category1 = new Category("Electronic Devices");
            Category category2 = new Category("Accessories");

            repository.saveAll(
                    List.of(category1, category2)
            );
        };
    }
}
