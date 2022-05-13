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
class JavaQuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionServiceImpl out;


    @Test
    void addWithStringParamTest() {
        when(questionRepository.add(QuestionServiceTestConstants.SECOND)).thenReturn(QuestionServiceTestConstants.SECOND);

        out.add(QuestionServiceTestConstants.SECOND_QUESTION, QuestionServiceTestConstants.SECOND_ANSWER);

        verify(questionRepository, times(1)).add(QuestionServiceTestConstants.SECOND);

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