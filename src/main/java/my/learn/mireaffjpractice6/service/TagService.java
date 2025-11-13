package my.learn.mireaffjpractice6.service;

import my.learn.mireaffjpractice6.dto.request.CreateTagRequest;
import my.learn.mireaffjpractice6.dto.responce.TagDTO;
import my.learn.mireaffjpractice6.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag createTag(CreateTagRequest tagRequest);
    List<Tag> getTags();
    Tag findTagByName(String name);
    List<Tag> getTagsByName(List<String> names);

}
