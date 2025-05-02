package com.abuzar.jobapp.Reviews.Service;

import com.abuzar.jobapp.Company.Entity.Company;
import com.abuzar.jobapp.Company.Service.CompanyService;
import com.abuzar.jobapp.Reviews.Entity.Review;
import com.abuzar.jobapp.Reviews.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    private CompanyService companyService;

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
}
