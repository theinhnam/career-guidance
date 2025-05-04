package com.theinhnam.schooldata.repositories.interestscore;

import com.theinhnam.schooldata.entities.InterestScore;
import com.theinhnam.schooldata.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IInterestScoreRepository extends JpaRepository<InterestScore, Integer> {
    Optional<InterestScore> findByUserAndMajorCode(User user, String majorCode);
    List<InterestScore> findTop3ByUserOrderByScoreDesc(User user);
}
