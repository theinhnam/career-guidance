package com.theinhnam.schooldata.services.question;

import com.theinhnam.schooldata.entities.InterestScore;
import com.theinhnam.schooldata.entities.Question;
import com.theinhnam.schooldata.entities.User;
import com.theinhnam.schooldata.repositories.interestscore.IInterestScoreRepository;
import com.theinhnam.schooldata.repositories.question.IQuestionRepository;
import com.theinhnam.schooldata.repositories.user.IUserRepository;
import com.theinhnam.schooldata.services.gpt.IGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        User user = userRepository.findById(userId).orElseThrow();
        Question question = new Question();
        question.setContent(content);
        question.setCreatedAt(LocalDateTime.now());
        question.setUser(user);
        questionRepository.save(question);

        List<String> majors = gptService.extractMajors(content);
        for (String m : majors) {
            InterestScore score = interestScoreRepository
                    .findByUserAndMajorCode(user, m)
                    .orElseGet(() -> {
                        InterestScore s = new InterestScore();
                        s.setUser(user);
                        s.setMajorCode(m);
                        return s;
                    });
            score.setScore(score.getScore() + 5);
            interestScoreRepository.save(score);
        }
    }
}
