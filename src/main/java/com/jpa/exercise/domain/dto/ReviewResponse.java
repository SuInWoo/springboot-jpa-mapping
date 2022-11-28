package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private String hospitalName;
    private Long reviewId;
    private String reviewPatientName;
    private String reviewTitle;
    private String reviewContent;
    private String message;

    public static ReviewResponse of(Review review) {
        return ReviewResponse.builder()
                .hospitalName(review.getHospital().getName())
                .reviewId(review.getId())
                .reviewPatientName(review.getPatientName())
                .reviewTitle(review.getTitle())
                .reviewContent(review.getContent())
                .message("해당 병원 리뷰 조회 완료")
                .build();
    }
}
