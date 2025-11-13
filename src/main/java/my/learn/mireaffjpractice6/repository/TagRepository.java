package my.learn.mireaffjpractice6.repository;

import my.learn.mireaffjpractice6.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("select t from Tag t where t.name = ?1")
    Optional<Tag> findByName(String name);

}
