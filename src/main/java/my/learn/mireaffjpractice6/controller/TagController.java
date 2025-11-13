package my.learn.mireaffjpractice6.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateTagRequest;
import my.learn.mireaffjpractice6.dto.responce.TagDTO;
import my.learn.mireaffjpractice6.exception.InternalServerException;
import my.learn.mireaffjpractice6.model.Tag;
import my.learn.mireaffjpractice6.service.TagService;
import my.learn.mireaffjpractice6.util.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController implements InformationController {

    private final TagService tagService;
    private final ObjectMapper mapper;

    @PostMapping
    public ResponseEntity<TagDTO> createTag(@Valid @RequestBody CreateTagRequest tagRequest) {
        Tag tag = tagService.createTag(tagRequest);
        TagDTO tagDTO = mapper.mapToDTO(tag);
        return new ResponseEntity<>(tagDTO, HttpStatus.CREATED);
    }

}
