package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.HospitalResponse;
import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.dto.ReviewResponse;
import com.jpa.exercise.service.HospitalService;
import com.jpa.exercise.service.ReviewService;
import io.swagger.annotations.ApiOperation;
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

    //리뷰 추가
    @ApiOperation(value = "리뷰 추가")
    @PostMapping("/{id}/reviews/add")
    public ResponseEntity<ReviewResponse> add(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest) {
        ReviewResponse reviewResponse = reviewService.addReview(id, reviewRequest);
        return ResponseEntity.ok().body(reviewResponse);
    }

    //리뷰 id로 조회
    @ApiOperation(value = "리뷰 번호로 조회 - 1개")
    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewResponse> findByIdReview(@PathVariable Long id) {
        ReviewResponse reviewResponse = reviewService.getReview(id);
        return ResponseEntity.ok().body(reviewResponse);
    }

    //병원 id로 리뷰 조회
    @ApiOperation(value = "병원 Id로 해당 병원 리뷰 리스트 조회")
    @GetMapping("/{id}/reviews/get")
    public ResponseEntity<List<ReviewResponse>> findByIdReviewList(@PathVariable Long id) {
        List<ReviewResponse> reviewResponses = reviewService.getHospitalReview(id);
        return ResponseEntity.ok().body(reviewResponses);
    }
}
