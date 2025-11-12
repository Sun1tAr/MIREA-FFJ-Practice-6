package my.learn.mireaffjpractice6.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException{

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase());
    }
}
