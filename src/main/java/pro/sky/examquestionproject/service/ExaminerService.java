package pro.sky.examquestionproject.service;

import pro.sky.examquestionproject.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
