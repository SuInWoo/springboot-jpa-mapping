package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.HospitalResponse;
import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.dto.ReviewResponse;
import com.jpa.exercise.service.HospitalService;
import com.jpa.exercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResponse> get(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest) {
        ReviewResponse reviewResponse = reviewService.addReview(id, reviewRequest);
        return ResponseEntity.ok().body(reviewResponse);
    }
}
