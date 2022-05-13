package pro.sky.examquestionproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examquestionproject.dto.Question;
import pro.sky.examquestionproject.repository.QuestionRepository;

import java.util.*;

@Service
public class MathQuestionServiceImpl implements QuestionService {

    private final Random random = new Random();
    private final QuestionRepository mathQuestionRepository;

    @Autowired
    public MathQuestionServiceImpl(@Qualifier("mathQuestionRepositoryImpl") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        Collection<Question> questions = mathQuestionRepository.getAll();
        if (questions.isEmpty()) {
            return null;
        }
        int count = random.nextInt(questions.size());
        return List.copyOf(questions).get(count);
    }
}
