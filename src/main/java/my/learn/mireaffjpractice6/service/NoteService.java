package my.learn.mireaffjpractice6.service;

import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.dto.responce.NoteDTO;
import my.learn.mireaffjpractice6.model.Note;

import java.util.Optional;


public interface NoteService {

    Note createNote(CreateNoteRequest noteRequest);

    Note getNoteById(Long id);

}
