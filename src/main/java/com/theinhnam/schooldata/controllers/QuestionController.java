package com.theinhnam.schooldata.controllers;

import com.theinhnam.schooldata.entities.InterestScore;
import com.theinhnam.schooldata.entities.User;
import com.theinhnam.schooldata.repositories.interestscore.IInterestScoreRepository;
import com.theinhnam.schooldata.services.question.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final IQuestionService questionService;
    private final IInterestScoreRepository interestScoreRepository;

    @PostMapping()
    public ResponseEntity<Void> ask(@RequestBody Map<String, String> body){
        Long userId = Long.parseLong(body.get("userId"));
        questionService.handleQuestion(userId, body.get("question"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/suggestions")
    public List<String> suggest(@RequestParam Long userId){
        User user = new User();
        user.setId(userId);
        return interestScoreRepository.findTop3ByUserOrderByScoreDesc(user).stream()
                                                                            .map(InterestScore::getMajorCode)
                                                                            .toList();
    }
}
