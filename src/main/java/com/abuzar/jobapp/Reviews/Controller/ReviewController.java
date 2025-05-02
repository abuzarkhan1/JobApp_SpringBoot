package com.abuzar.jobapp.Reviews.Controller;

import com.abuzar.jobapp.Reviews.Entity.Review;
import com.abuzar.jobapp.Reviews.Service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewSaved =  reviewService.addReview(companyId,review);
        if(isReviewSaved){
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }
    }
}
