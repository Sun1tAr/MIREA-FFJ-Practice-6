package my.learn.mireaffjpractice6.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.dto.responce.NoteDTO;
import my.learn.mireaffjpractice6.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //todo
public class NoteServiceImpl implements NoteService {
    @Override
    public Optional<NoteDTO> createNote(CreateNoteRequest noteRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<NoteDTO> getNoteById(Long id) {
        return Optional.empty();
    }
}
