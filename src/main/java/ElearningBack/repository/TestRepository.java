package ElearningBack.repository;

import ElearningBack.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TestRepository extends JpaRepository<Test,Long> {
}
