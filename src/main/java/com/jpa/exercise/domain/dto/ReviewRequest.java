package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private Long hospitalId;
    private String title;
    private String content;
    private String patientName;

    public Review toEntity(Hospital hospital) {
        Review review = Review.builder()
                .title(this.title)
                .content(this.content)
                .patientName(this.patientName)
                .hospital(hospital)
                .build();

        return review;
    }
}
