package com.theinhnam.schooldata.controllers;

import com.theinhnam.schooldata.dto.MajorDTO;
import com.theinhnam.schooldata.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/majors")
@RequiredArgsConstructor
public class MajorController {
    private final RecommendationService recommendationService;

    @GetMapping("/recommend")
    public ResponseEntity<List<MajorDTO>> recommendMajors(@RequestParam Long userId) {
        List<MajorDTO> result = recommendationService.recommendMajorsForUser(userId);
        return ResponseEntity.ok(result);
    }
}
