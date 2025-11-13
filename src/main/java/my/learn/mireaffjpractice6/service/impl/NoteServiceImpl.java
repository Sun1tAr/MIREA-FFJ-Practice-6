package my.learn.mireaffjpractice6.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.exception.NotFoundException;
import my.learn.mireaffjpractice6.model.Note;
import my.learn.mireaffjpractice6.model.Tag;
import my.learn.mireaffjpractice6.model.User;
import my.learn.mireaffjpractice6.repository.NoteRepository;
import my.learn.mireaffjpractice6.service.NoteService;
import my.learn.mireaffjpractice6.service.TagService;
import my.learn.mireaffjpractice6.service.UserService;
import my.learn.mireaffjpractice6.util.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserService userService;
    private final TagService tagService;


    @Override
    public Note createNote(CreateNoteRequest noteRequest) {
        User user = userService.findUserById(noteRequest.getUserId());
        List<Tag> tags = tagService.getTagsByName(noteRequest.getTags());
        Note note = Note.builder()
                .title(noteRequest.getTitle())
                .content(noteRequest.getContent())
                .user(user)
                .tags(tags)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new NotFoundException("Note was not found");
        }
        return note.get();
    }
}
