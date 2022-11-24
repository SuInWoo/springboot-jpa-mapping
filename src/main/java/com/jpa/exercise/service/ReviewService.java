package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.dto.ReviewResponse;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import com.jpa.exercise.repository.HospitalRepository;
import com.jpa.exercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewResponse addReview(Long hospitalId, ReviewRequest reviewRequest) {
        Optional<Hospital> optHospital = hospitalRepository.findById(hospitalId);
        Review review = reviewRequest.toEntity(optHospital.get());
        Review savedReview = reviewRepository.save(review);

        return new ReviewResponse(savedReview.getId(), savedReview.getPatientName(),
                savedReview.getTitle(), savedReview.getContent(), "등록완료");
    }

    public ReviewResponse getReview(Long reviewId) {
        Optional<Review> optReview = reviewRepository.findById(reviewId);
        Review selectReview = optReview.get();

        return new ReviewResponse(selectReview.getId(), selectReview.getPatientName(),
                selectReview.getTitle(), selectReview.getContent(), "1개 조회 완료");

    }

    public List<ReviewResponse> getHospitalReview(Long hospitalId) {
        Optional<Hospital> optHospital = hospitalRepository.findById(hospitalId);
        List<Review> reviewList = optHospital.get().getReviews();
        List<ReviewResponse> reviewResponses = reviewList.stream()
                .map(review -> ReviewResponse.of(review))
                .collect(Collectors.toList());
        return reviewResponses;
    }
}
