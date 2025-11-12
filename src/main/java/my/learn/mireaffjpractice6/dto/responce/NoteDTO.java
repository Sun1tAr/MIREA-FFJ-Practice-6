package my.learn.mireaffjpractice6.dto.responce;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Builder;
import my.learn.mireaffjpractice6.model.User;

import java.time.LocalDateTime;


@Builder
public class NoteDTO {

    private Long id;

    private String title;

    private String content;

    private Long userId;

    private User user;

    @JsonFormat(shape = Shape.STRING)
    private LocalDateTime createdAt;

    @JsonFormat(shape = Shape.STRING)
    private LocalDateTime updatedAt;

}
