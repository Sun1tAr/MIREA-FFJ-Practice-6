package my.learn.mireaffjpractice6.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateNoteRequest {

    private String title;

    private String content;

    private Long userId;

    private List<String> tags;


}
