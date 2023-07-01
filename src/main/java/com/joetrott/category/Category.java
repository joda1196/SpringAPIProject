package com.joetrott.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joetrott.product.Product;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name="category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;
//    ---------------------------------------------------------------------------------
    public Category(String name) {
        this.name = name;
    }

    public Category() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Product> getProducts() {
        return products;
    }
    public void assignCategoryToProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

