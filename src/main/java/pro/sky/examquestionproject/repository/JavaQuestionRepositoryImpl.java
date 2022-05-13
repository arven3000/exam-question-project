package pro.sky.examquestionproject.repository;

import org.springframework.stereotype.Component;
import pro.sky.examquestionproject.dto.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class JavaQuestionRepositoryImpl implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    public JavaQuestionRepositoryImpl() {
    }

    @PostConstruct
    public void init() {
        questions.add(new Question("javaQuestion_1", "javaAnswer_1"));
        questions.add(new Question("javaQuestion_2", "javaAnswer_2"));
        questions.add(new Question("javaQuestion_3", "javaAnswer_3"));
        questions.add(new Question("javaQuestion_4", "javaAnswer_4"));
        questions.add(new Question("javaQuestion_5", "javaAnswer_5"));
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
