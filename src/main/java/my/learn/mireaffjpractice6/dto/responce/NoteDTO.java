package my.learn.mireaffjpractice6.dto.responce;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
public class NoteDTO {

    private Long id;

    private String title;

    private String content;

    private Long userId;

    @JsonFormat(shape = Shape.STRING)
    private LocalDateTime createdAt;

    private List<String> tagNames;

    @JsonFormat(shape = Shape.STRING)
    private LocalDateTime updatedAt;

}
