package my.learn.mireaffjpractice6.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.dto.responce.NoteDTO;
import my.learn.mireaffjpractice6.model.Note;
import my.learn.mireaffjpractice6.service.NoteService;
import my.learn.mireaffjpractice6.util.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController implements InformationController {

    private final NoteService noteService;
    private final ObjectMapper mapper;

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody CreateNoteRequest noteRequest) {
        Note note = noteService.createNote(noteRequest);

        NoteDTO noteDTO = mapper.mapToDTO(note);

        return new ResponseEntity<>(noteDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable(name = "id") Long id) {
        Note note = noteService.getNoteById(id);
        NoteDTO noteDTO = mapper.mapToDTO(note);
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

}
