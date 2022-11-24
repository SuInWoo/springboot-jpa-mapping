package com.jpa.exercise.service;

import com.jpa.exercise.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

}
