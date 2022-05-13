package pro.sky.examquestionproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examquestionproject.exception.CountQuestionsException;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void getQuestionsTest() {

        when(questionServiceMock.getAll()).thenReturn(Collections.emptyList());

        out.getQuestions(0);

        verify(questionServiceMock, times(2)).getAll();

        when(questionServiceMock.getAll()).thenReturn(QuestionServiceTestConstants.THIRD_COLLECTION);
        when(questionServiceMock.getRandomQuestion()).thenReturn(QuestionServiceTestConstants.SECOND);

        out.getQuestions(1);

        verify(questionServiceMock, times(4)).getAll();
        verify(questionServiceMock, times(1)).getRandomQuestion();
    }

    @Test
    void getQuestionsTestWithThrowException() {

        when(questionServiceMock.getAll()).thenReturn(Collections.emptyList());

        Assertions.assertThrows(CountQuestionsException.class, () -> out.getQuestions(1));

    }
}