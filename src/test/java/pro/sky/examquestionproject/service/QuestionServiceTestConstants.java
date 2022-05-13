package pro.sky.examquestionproject.service;

import pro.sky.examquestionproject.dto.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class QuestionServiceTestConstants {
    public static final String FIRST_QUESTION = "question_1";
    public static final String SECOND_QUESTION = "question_2";
    public static final String THIRD_QUESTION = "question_3";
    public static final String FORTH_QUESTION = "question_4";
    public static final String FIRST_ANSWER = "answer_1";
    public static final String SECOND_ANSWER = "answer_2";
    public static final String THIRD_ANSWER = "answer_3";
    public static final String FORTH_ANSWER = "answer_4";
    public static final Question FIRST = new Question(FIRST_QUESTION, FIRST_ANSWER);
    public static final Question SECOND = new Question(SECOND_QUESTION, SECOND_ANSWER);
    public static final Question THIRD = new Question(THIRD_QUESTION, THIRD_ANSWER);
    public static final Question FORTH = new Question(FORTH_QUESTION, FORTH_ANSWER);
    public static final Collection<Question> SECOND_COLLECTION = new HashSet<>(List.of(FORTH, FIRST, SECOND, THIRD));
    public static final Collection<Question> THIRD_COLLECTION = new HashSet<>(List.of(FORTH));


}
