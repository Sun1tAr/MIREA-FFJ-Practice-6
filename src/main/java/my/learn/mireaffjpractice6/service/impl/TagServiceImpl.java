package my.learn.mireaffjpractice6.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.learn.mireaffjpractice6.dto.request.CreateTagRequest;
import my.learn.mireaffjpractice6.dto.responce.TagDTO;
import my.learn.mireaffjpractice6.exception.NotFoundException;
import my.learn.mireaffjpractice6.model.Tag;
import my.learn.mireaffjpractice6.repository.TagRepository;
import my.learn.mireaffjpractice6.service.TagService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public Tag createTag(CreateTagRequest tagRequest) {
        Tag tag = Tag.builder()
                .name(tagRequest.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findTagByName(String name) {
        Optional<Tag> tag = tagRepository.findByName(name);
        if (tag.isEmpty()) {
            throw new NotFoundException("Tag " + name + " was not found");
        }
        return tag.get();
    }

    @Override
    public List<Tag> getTagsByName(List<String> names) {
        List<Tag> tags = new ArrayList<>();
        names.parallelStream().forEach(name -> {
            try {
                tags.add(findTagByName(name));
            } catch (NotFoundException e) {
                log.warn(e.getMessage());
            }
        });
        return tags;
    }
}
