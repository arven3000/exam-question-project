package pro.sky.examquestionproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class QuestionExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleException400(CountQuestionsException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(getMapResponseEntity(ex.getMessage(), request, status), status);
    }

    private Map<String, String> getMapResponseEntity(String message, HttpServletRequest request, HttpStatus status) {
        return getStringStringMap(message, request, status);
    }

    private static Map<String, String> getStringStringMap(String message, HttpServletRequest request, HttpStatus status) {
        Map<String, String> answer = new LinkedHashMap<>();
        answer.put("message ", message);
        answer.put("error ", status.getReasonPhrase());
        answer.put("status ", String.valueOf(status.value()));
        answer.put("timestamp ", LocalDateTime.now().toString());
        answer.put("path ", request.getRequestURI());
        return answer;
    }
}
