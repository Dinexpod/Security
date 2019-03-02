package mate.academy.spring.service.impl;

import mate.academy.spring.dto.DeveloperDto;
import mate.academy.spring.dto.ProjectDto;
import mate.academy.spring.model.Developer;
import mate.academy.spring.model.Project;
import mate.academy.spring.repository.DeveloperRepository;
import mate.academy.spring.repository.ProjectRepository;
import mate.academy.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDto getProject(Long id) {
        Project project = projectRepository.getOne(id);
        return ProjectDto.doDtoProject(project);
    }

    @Override
    public List<ProjectDto> getAll() {
        List<Project> projects = projectRepository.findAll();
        return projects
                .stream()
                .map(ProjectDto::doDtoProject)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
