package pro.sky.examquestionproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CountQuestionsException extends RuntimeException {
    public CountQuestionsException(String message) {
        super(message);
    }
}
