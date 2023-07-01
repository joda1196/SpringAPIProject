package com.joetrott.review;

import com.joetrott.product.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review getOneReview(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalStateException("review with this id doesn't exist"));
    }

    public void addNewReview(Review review) {
        reviewRepository.save(review);
    }

    @Transactional
    public void updateReview(Long reviewId,
                              int rating,
                              String comment) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalStateException(
                        "review with id " + reviewId + " does not exist"
                ));
    }

    public void deleteReview(Long reviewId) {
        boolean exists = reviewRepository.existsById(reviewId);
        if (!exists) {
            throw new IllegalStateException(
                    "review with id " + reviewId + " does not exist"
            );
        }
        reviewRepository.deleteById(reviewId);
    }
}
