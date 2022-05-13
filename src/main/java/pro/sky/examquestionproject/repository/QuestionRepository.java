package pro.sky.examquestionproject.repository;

import pro.sky.examquestionproject.dto.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
