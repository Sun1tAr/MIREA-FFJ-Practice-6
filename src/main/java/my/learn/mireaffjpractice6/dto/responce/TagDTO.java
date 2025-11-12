package my.learn.mireaffjpractice6.dto.responce;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class TagDTO {

    private Long id;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
