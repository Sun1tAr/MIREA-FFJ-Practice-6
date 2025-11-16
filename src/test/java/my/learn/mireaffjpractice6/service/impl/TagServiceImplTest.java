package my.learn.mireaffjpractice6.service.impl;

import my.learn.mireaffjpractice6.dto.request.CreateTagRequest;
import my.learn.mireaffjpractice6.exception.NotFoundException;
import my.learn.mireaffjpractice6.model.Tag;
import my.learn.mireaffjpractice6.repository.TagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TagServiceImplTest {

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagServiceImpl tagService;

    private List<Tag> tagList;

    @BeforeEach
    void setUp() {
        tagList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            tagList.add(Tag.builder()
                    .name("TestTag" + i)
                    .build());
        }
    }

    @Test
    public void createTagTest(){
        CreateTagRequest req = new CreateTagRequest();
        req.setName("TestTag");

        Tag t = Tag.builder()
                .name(req.getName())
                .build();

        when(tagRepository.save(any(Tag.class))).thenReturn(t);

        Tag tag = tagService.createTag(req);

        assertNotNull(tag);
        assertEquals(tag.getName(),req.getName());
    }

    @Test
    public void getTagsTest_foundFewTags(){
        when(tagRepository.findAll()).thenReturn(tagList);

        List<Tag> tags = tagService.getTags();
        assertNotNull(tags);
        assertEquals(tagList.size(),tags.size());

    }

    @Test
    public void getTagsTest_notFoundTags(){
        when(tagRepository.findAll()).thenReturn(List.of());

        List<Tag> tags = tagService.getTags();
        assertNotNull(tags);
        assertEquals(0,tags.size());

    }

    @Test
    public void findTagByNameTest_tagFound(){
        String name = tagList.get(0).getName();
        when(tagRepository.findByName(name)).thenReturn(Optional.of(tagList.get(0)));

        Tag tagByName = tagService.findTagByName(name);
        assertNotNull(tagByName);
        assertEquals(tagList.get(0),tagByName);

    }

    @Test
    public void findTagByNameTest_tagNotFound(){
        String name = tagList.get(0).getName();
        when(tagRepository.findByName(name)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class,  () -> tagService.findTagByName(name));
    }

    @Test
    public void getTagsByNameTest_allTagsFound(){
        List<String> tagNames = new ArrayList<>();
        tagList.forEach(t -> tagNames.add(t.getName()));

        for (int i = 0; i < tagList.size(); i++) {
            when(tagRepository.findByName(tagNames.get(i))).
                    thenReturn(Optional.of(tagList.get(i)));
        }

        List<Tag> tagsByName = tagService.getTagsByName(tagNames);
        assertNotNull(tagsByName);
        assertEquals(tagList.size(),tagsByName.size());


    }

    @Test
    public void getTagsByNameTest_someTagsFound(){
        List<String> tagNames = new ArrayList<>();
        tagList.forEach(t -> tagNames.add(t.getName()));
        int countOfNotFound = 2;

        for (int i = 0; i < (tagList.size() - countOfNotFound); i++) {
            when(tagRepository.findByName(tagNames.get(i))).
                    thenReturn(Optional.of(tagList.get(i)));
        }

        List<Tag> tagsByName = tagService.getTagsByName(tagNames);
        assertNotNull(tagsByName);
        assertEquals(tagList.size() - countOfNotFound,tagsByName.size());

    }

    @Test
    public void getTagsByNameTest_noneTagsFound(){
        List<String> tagNames = new ArrayList<>();
        tagList.forEach(t -> tagNames.add(t.getName()));
        int countOfNotFound = tagList.size();

        for (int i = 0; i < (tagList.size() - countOfNotFound); i++) {
            when(tagRepository.findByName(tagNames.get(i))).
                    thenReturn(Optional.of(tagList.get(i)));
        }

        List<Tag> tagsByName = tagService.getTagsByName(tagNames);
        assertNotNull(tagsByName);
        assertEquals(tagList.size() - countOfNotFound,tagsByName.size());

    }


}