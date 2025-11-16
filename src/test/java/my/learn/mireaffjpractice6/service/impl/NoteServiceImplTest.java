package my.learn.mireaffjpractice6.service.impl;

import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.model.Note;
import my.learn.mireaffjpractice6.model.Tag;
import my.learn.mireaffjpractice6.model.User;
import my.learn.mireaffjpractice6.repository.NoteRepository;
import my.learn.mireaffjpractice6.service.TagService;
import my.learn.mireaffjpractice6.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceImplTest {

    @Mock
    private NoteRepository noteRepository;
    @Mock
    private UserService userService;
    @Mock
    private TagService tagService;

    @InjectMocks
    private NoteServiceImpl noteService;


    @Test
    public void testCreateNote() {
        // Given
        User u = User.builder()
                .id(1L)
                .name("User")
                .email("user@mail.com")
                .notes(List.of())
                .build();

        List<Tag> tagList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            tagList.add(Tag.builder()
                    .name("TestTag" + i)
                    .build());
        }

        CreateNoteRequest req = new CreateNoteRequest();
        req.setTitle("TestTitle");
        req.setContent("TestContent");
        req.setUserId(u.getId());
        req.setTags(tagList.stream().map(t -> t.getName()).toList());

        Note note = Note.builder()
                .id(1L)
                .title(req.getTitle())
                .content(req.getContent())
                .user(u)
                .tags(tagList)
                .build();

        when(userService.findUserById(u.getId())).thenReturn(u);
        when(tagService.getTagsByName(req.getTags())).thenReturn(tagList);
        when(noteRepository.save(any(Note.class))).thenReturn(note);

        // When
        Note createdNote = noteService.createNote(req);

        // Then
        assertNotNull(createdNote);
        assertEquals(req.getTitle(), createdNote.getTitle());
        assertEquals(req.getContent(), createdNote.getContent());
        assertEquals(u, createdNote.getUser());
        assertEquals(tagList, createdNote.getTags());
    }

    @Test
    public void getNoteById_ShouldCallRepositoryWithCorrectId() {
        // Given
        Long noteId = 1L;
        Note expectedNote = mock(Note.class);
        when(noteRepository.findById(noteId)).thenReturn(Optional.of(expectedNote));

        // When
        Note result = noteService.getNoteById(noteId);

        // Then
        // Проверяем ЧТО репозиторий вызван с правильным ID
        verify(noteRepository, times(1)).findById(noteId);

        // Проверяем что возвращается ТОТ ЖЕ объект что из репозитория
        assertSame(expectedNote, result);
    }










}