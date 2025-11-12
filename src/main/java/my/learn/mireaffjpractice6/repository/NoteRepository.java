package my.learn.mireaffjpractice6.repository;

import my.learn.mireaffjpractice6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
