package app.repo;

import app.models.Task;
import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findByAuthor(User name);
    void deleteById(Long id);
}
