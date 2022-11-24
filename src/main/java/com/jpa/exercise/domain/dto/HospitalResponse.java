package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Long hospitalId;
    private String hospitalName;
    private List<Review> reviews;
}
