package my.learn.mireaffjpractice6.service;

import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.dto.responce.NoteDTO;

import java.util.Optional;


public interface NoteService {

    Optional<NoteDTO> createNote(CreateNoteRequest noteRequest);

    Optional<NoteDTO> getNoteById(Long id);

}
