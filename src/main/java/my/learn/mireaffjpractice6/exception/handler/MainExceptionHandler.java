package my.learn.mireaffjpractice6.exception.handler;

import lombok.extern.slf4j.Slf4j;
import my.learn.mireaffjpractice6.exception.AppException;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class MainExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleException(AppException e) {
        Map<String, String> map = getResponseBody(
                e.getMessage(),
                e.getErrorCode(),
                e.getStatus()
        );
        log.warn(e.getMessage());
        return new ResponseEntity<>(map, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception e) {
        Map<String, String> body = getResponseBody(
                e.getMessage(),
                "Internal server error",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        log.error(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException e) {
        Map<String, String> body = getResponseBody(
                e.getMessage(),
                e.getDetailMessageCode(),
                (HttpStatus) e.getStatusCode()
        );
        log.warn(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private Map<String, String> getResponseBody(String message, String errorCode, HttpStatus status) {
        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("error_code", errorCode);
        map.put("status", status.toString());
        return map;
    }

}
