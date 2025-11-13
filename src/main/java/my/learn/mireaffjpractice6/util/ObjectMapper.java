package my.learn.mireaffjpractice6.util;

import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.dto.request.CreateTagRequest;
import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.dto.responce.NoteDTO;
import my.learn.mireaffjpractice6.dto.responce.TagDTO;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;
import my.learn.mireaffjpractice6.model.Note;
import my.learn.mireaffjpractice6.model.Tag;
import my.learn.mireaffjpractice6.model.User;

import java.util.Optional;

public interface ObjectMapper {

    UserDTO mapToDTO(User user);

    NoteDTO mapToDTO(Note note);

    TagDTO mapToDTO(Tag tag);
}
