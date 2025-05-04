package com.theinhnam.schooldata.repositories.interestscore;

import com.theinhnam.schooldata.entities.InterestScore;
import com.theinhnam.schooldata.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInterestScoreRepository extends JpaRepository<InterestScore, Integer> {
    List<InterestScore> findTop3ByUserOrderByScoreDesc(User user);
}
