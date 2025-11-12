package my.learn.mireaffjpractice6.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateTagRequest;
import my.learn.mireaffjpractice6.dto.responce.TagDTO;
import my.learn.mireaffjpractice6.exception.InternalServerException;
import my.learn.mireaffjpractice6.service.TagService;
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

    @PostMapping
    public ResponseEntity<TagDTO> createTag(@Valid @RequestBody CreateTagRequest tagRequest) {
        Optional<TagDTO> tag = tagService.createTag(tagRequest);
        if (tag.isPresent()) {
            return new ResponseEntity<>(tag.get(), HttpStatus.CREATED);
        } else {
            throw new InternalServerException("Tag was not created");
        }
    }

}
