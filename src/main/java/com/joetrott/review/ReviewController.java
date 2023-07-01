package com.joetrott.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }

    @PostMapping
    public void createReview(@RequestBody Review review) {
        reviewService.addNewReview(review);
    }

    @DeleteMapping(path = "{reviewId}")
    public void deleteReview (@PathVariable("reviewId") Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @PutMapping(path = "{reviewId}")
    public void updateReview(
            @PathVariable("reviewId") Long reviewId,
            @RequestParam(required = false) int rating,
            @RequestParam(required = false) String comment
    ) {
        reviewService.updateReview(reviewId, rating, comment);
    }
}
