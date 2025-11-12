package my.learn.mireaffjpractice6.service.impl;

import my.learn.mireaffjpractice6.dto.request.CreateTagRequest;
import my.learn.mireaffjpractice6.dto.responce.TagDTO;
import my.learn.mireaffjpractice6.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service //todo
public class TagServiceImpl implements TagService {
    @Override
    public Optional<TagDTO> createTag(CreateTagRequest tagRequest) {
        return Optional.empty();
    }

    @Override
    public List<TagDTO> getTags() {
        return List.of();
    }
}
