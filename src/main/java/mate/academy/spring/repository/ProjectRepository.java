package mate.academy.spring.repository;

import mate.academy.spring.model.Developer;
import mate.academy.spring.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
