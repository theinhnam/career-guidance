package com.theinhnam.schooldata.services.question;

import com.theinhnam.schooldata.repositories.interestscore.IInterestScoreRepository;
import com.theinhnam.schooldata.repositories.question.IQuestionRepository;
import com.theinhnam.schooldata.repositories.user.IUserRepository;
import com.theinhnam.schooldata.services.gpt.IGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionRepository questionRepository;
    private final IUserRepository userRepository;
    private final IInterestScoreRepository interestScoreRepository;
    private final IGptService gptService;

    @Autowired
    public QuestionServiceImpl(IQuestionRepository questionRepository, IUserRepository userRepository, IInterestScoreRepository interestScoreRepository, IGptService gptService) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.interestScoreRepository = interestScoreRepository;
        this.gptService = gptService;
    }

    @Override
    public void handleQuestion(Long userId, String content) {

    }
}
