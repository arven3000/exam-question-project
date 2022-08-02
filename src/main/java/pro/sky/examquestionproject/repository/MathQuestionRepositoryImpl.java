package pro.sky.examquestionproject.repository;

import org.springframework.stereotype.Component;
import pro.sky.examquestionproject.dto.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class MathQuestionRepositoryImpl implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    public MathQuestionRepositoryImpl() {
    }

    @PostConstruct
    public void init() {
        questions.add(new Question("mathQuestion_1", "mathAnswer_1"));
        questions.add(new Question("mathQuestion_2", "mathAnswer_2"));
        questions.add(new Question("mathQuestion_3", "mathAnswer_3"));
        questions.add(new Question("mathQuestion_4", "mathAnswer_4"));
        questions.add(new Question("mathQuestion_5", "mathAnswer_5"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
