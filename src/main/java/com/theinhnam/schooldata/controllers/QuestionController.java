package com.theinhnam.schooldata.controllers;

import com.theinhnam.schooldata.services.question.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final IQuestionService questionService;

    @PostMapping()
    public ResponseEntity<Void> ask(@RequestBody Map<String, String> body){
        //TODO When user ask AI, follow a user's question to recommend major
        Long userId = Long.parseLong(body.get("userId"));
        questionService.handleQuestion(userId, body.get("question"));
        return ResponseEntity.ok().build();
    }
}
