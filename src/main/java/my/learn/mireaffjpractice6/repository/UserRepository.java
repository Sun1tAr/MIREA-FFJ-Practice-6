package my.learn.mireaffjpractice6.repository;

import my.learn.mireaffjpractice6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
