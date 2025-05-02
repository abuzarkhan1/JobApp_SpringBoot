package com.abuzar.jobapp.Reviews.Service;

import com.abuzar.jobapp.Reviews.Entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

}
