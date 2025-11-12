package my.learn.mireaffjpractice6.repository;

import my.learn.mireaffjpractice6.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
