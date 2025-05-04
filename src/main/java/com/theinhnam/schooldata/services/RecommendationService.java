package com.theinhnam.schooldata.services;

import com.theinhnam.schooldata.dto.MajorDTO;
import com.theinhnam.schooldata.entities.InterestScore;
import com.theinhnam.schooldata.entities.Major;
import com.theinhnam.schooldata.entities.User;
import com.theinhnam.schooldata.repositories.interestscore.IInterestScoreRepository;
import com.theinhnam.schooldata.repositories.major.IMajorRepository;
import com.theinhnam.schooldata.repositories.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final IInterestScoreRepository interestRepo;
    private final IMajorRepository majorRepo;
    private final IUserRepository userRepo;

    @Cacheable(value = "recommendations", key = "#userId")
    public List<MajorDTO> recommendMajorsForUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<InterestScore> scores = interestRepo.findTop3ByUserOrderByScoreDesc(user);
        return scores.stream()
                .map(score -> {
                    Major major = majorRepo.findById(score.getMajorCode())
                            .orElse(null);
                    if (major == null) return null;
                    return new MajorDTO(
                            major.getCode(),
                            major.getName(),
                            major.getDescription(),
                            score.getScore()
                    );
                })
                .filter(Objects::nonNull)
                .toList();
    }
}
