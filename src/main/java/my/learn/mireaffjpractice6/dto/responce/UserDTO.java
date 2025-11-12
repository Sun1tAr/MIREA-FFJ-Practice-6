package my.learn.mireaffjpractice6.dto.responce;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import my.learn.mireaffjpractice6.model.Note;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private List<Note> notes;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime updatedAt;

}
