package com.joetrott.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joetrott.product.Product;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Review {
    @Id
    @SequenceGenerator(
            name="review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private Long id;
    private int rating;
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id", insertable=false, updatable = false)
    private Product product;
    //    ---------------------------------------------------------------------------------

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Review() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
