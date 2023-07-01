package com.joetrott.product;


import com.joetrott.category.Category;
import com.joetrott.category.CategoryService;
import com.joetrott.review.Review;
import com.joetrott.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final ProductService productService;
    private final ReviewService reviewService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, ReviewService reviewService, CategoryService categoryService) {
        this.productService = productService;
        this.reviewService = reviewService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public Product getOneProduct(@PathVariable("productId") Long productId) {
        return productService.getOneProduct(productId);
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct (@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String desc
    ) {
        productService.updateProduct(productId, name, desc);
    }

    @PutMapping(path = "{productId}/reviews/{reviewId}")
    public Product addReviewToProduct(@PathVariable Long productId, @PathVariable Long reviewId) {
        Product product = productService.getOneProduct(productId);
        Review review = reviewService.getOneReview(reviewId);
        product.addReview(review);
        return productService.saveToRepo(product);
    }

    @PutMapping(path = "{productId}/categories/{categoryId}")
    public Product addCategoryToProduct(@PathVariable Long productId, @PathVariable Long categoryId) {
        Product product = productService.getOneProduct(productId);
        Category category = categoryService.getOneCategory(categoryId);
        product.addCategory(category);
        return productService.saveToRepo(product);
    }
 }
