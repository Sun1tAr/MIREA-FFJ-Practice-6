package my.learn.mireaffjpractice6.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.dto.responce.NoteDTO;
import my.learn.mireaffjpractice6.exception.InternalServerException;
import my.learn.mireaffjpractice6.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController implements InformationController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody CreateNoteRequest noteRequest) {
        Optional<NoteDTO> note = noteService.createNote(noteRequest);
        if (note.isEmpty()) {
            throw new InternalServerException("Note was not created");
        }

        return new ResponseEntity<>(note.get(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable(name = "id") Long id) {
        Optional<NoteDTO> note = noteService.getNoteById(id);

        if (note.isEmpty()) {
            throw new InternalServerException("Note was not created");
        }

        return new ResponseEntity<>(note.get(), HttpStatus.OK);
    }

}
