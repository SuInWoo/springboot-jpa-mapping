package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.dto.ReviewResponse;
import com.jpa.exercise.service.HospitalService;
import com.jpa.exercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews/add")
    public ResponseEntity<ReviewResponse> add(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest) {
        ReviewResponse reviewResponse = reviewService.addReview(id, reviewRequest);
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewResponse> findByIdReview(@PathVariable Long id) {
        ReviewResponse reviewResponse = reviewService.getReview(id);
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/{id}/reviews/get")
    public ResponseEntity<List<ReviewResponse>> findByIdReviewList(@PathVariable Long id) {
        List<ReviewResponse> reviewResponses = reviewService.getHospitalReview(id);
        return ResponseEntity.ok().body(reviewResponses);
    }
}
