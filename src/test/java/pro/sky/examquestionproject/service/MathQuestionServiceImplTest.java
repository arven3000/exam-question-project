package pro.sky.examquestionproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examquestionproject.repository.QuestionRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionServiceImpl out;

    @Test
    void addWithStringParamTest() {
        when(questionRepository.add(QuestionServiceTestConstants.FIRST)).thenReturn(QuestionServiceTestConstants.FIRST);

        out.add(QuestionServiceTestConstants.FIRST_QUESTION, QuestionServiceTestConstants.FIRST_ANSWER);

        verify(questionRepository, times(1)).add(QuestionServiceTestConstants.FIRST);
    }

    @Test
    void addWithObjectParamTest() {
        when(questionRepository.add(QuestionServiceTestConstants.FIRST)).thenReturn(QuestionServiceTestConstants.FIRST);

        out.add(QuestionServiceTestConstants.FIRST);

        verify(questionRepository, times(1)).add(QuestionServiceTestConstants.FIRST);
    }

    @Test
    void removeTest() {
        when(questionRepository.remove(QuestionServiceTestConstants.FIRST)).thenReturn(QuestionServiceTestConstants.FIRST);

        out.remove(QuestionServiceTestConstants.FIRST);

        verify(questionRepository, times(1)).remove(QuestionServiceTestConstants.FIRST);
    }

    @Test
    void getAllTest() {
        when(questionRepository.getAll()).thenReturn(QuestionServiceTestConstants.SECOND_COLLECTION);

        out.getAll();

        verify(questionRepository, times(1)).getAll();

        Assertions.assertEquals(4, out.getAll().size());
    }
}