package my.learn.mireaffjpractice6.util.impl;

import my.learn.mireaffjpractice6.dto.responce.NoteDTO;
import my.learn.mireaffjpractice6.dto.responce.TagDTO;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;
import my.learn.mireaffjpractice6.model.Note;
import my.learn.mireaffjpractice6.model.Tag;
import my.learn.mireaffjpractice6.model.User;
import my.learn.mireaffjpractice6.util.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperImpl implements ObjectMapper {
    @Override
    public UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .notes(user.getNotes())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    @Override
    public NoteDTO mapToDTO(Note note) {
        return NoteDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .userId(note.getUser().getId())
                .tagNames(note.getTags().stream().map(Tag::getName).toList())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }

    @Override
    public TagDTO mapToDTO(Tag tag) {
        return TagDTO.builder()
                .id(tag.getId())
                .name(tag.getName())
                .createdAt(tag.getCreatedAt())
                .updatedAt(tag.getUpdatedAt())
                .build();
    }
}
