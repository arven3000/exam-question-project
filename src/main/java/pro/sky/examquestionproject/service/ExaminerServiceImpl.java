package pro.sky.examquestionproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examquestionproject.dto.Question;
import pro.sky.examquestionproject.exception.CountQuestionsException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Random random = new Random();
    private final QuestionService javaQuestionService;

    private final QuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> questionSet = new HashSet<>();

        if (amount > (javaQuestionService.getAll().size() + mathQuestionService.getAll().size())) {
            throw new CountQuestionsException("Ваш запрос превышает количество вопросов!");
        }
        while (questionSet.size() < amount) {
            int count = random.nextInt(10) + 1;
            if (count % 2 == 0) {
                questionSet.add(javaQuestionService.getRandomQuestion());
            } else {
                questionSet.add(mathQuestionService.getRandomQuestion());
            }
        }
        return questionSet;
    }
}
