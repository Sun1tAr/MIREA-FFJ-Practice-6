package my.learn.mireaffjpractice6.dto.responce;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Data
public class StatusDTO {
    private final HttpStatus status;
    private final String message;
}
