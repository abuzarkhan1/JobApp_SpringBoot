package com.abuzar.jobapp.Reviews.Service;

import com.abuzar.jobapp.Company.Entity.Company;
import com.abuzar.jobapp.Company.Service.CompanyService;
import com.abuzar.jobapp.Reviews.Entity.Review;
import com.abuzar.jobapp.Reviews.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
      List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        for (Review review : reviews) {
            if (review.getId().equals(reviewId)) {
                return review;
            }
        }
        return null;
    }

    @Override
    public void updateReview(Long companyId, Long reviewId, Review review) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        for (Review existingReview : reviews) {
            if (existingReview.getId().equals(reviewId)) {
                existingReview.setTitle(review.getTitle());
                existingReview.setDescription(review.getDescription());
                existingReview.setRating(review.getRating());
                reviewRepository.save(existingReview);
                return;
            }
        }
        throw new RuntimeException("Review not found");
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        for (Review review : reviews) {
            if (review.getId().equals(reviewId)) {
                reviewRepository.delete(review);
                return true;
            }
        }
        return false;
    }
}
