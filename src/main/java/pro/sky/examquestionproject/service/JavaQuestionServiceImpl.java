package pro.sky.examquestionproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examquestionproject.dto.Question;
import pro.sky.examquestionproject.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Random random = new Random();
    private final QuestionRepository javaQuestionRepository;

    @Autowired
    public JavaQuestionServiceImpl(@Qualifier("javaQuestionRepositoryImpl") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        Collection<Question> questions = javaQuestionRepository.getAll();
        if (questions.isEmpty()) {
            return null;
        }
        int count = random.nextInt(questions.size());
        return List.copyOf(questions).get(count);
    }
}
