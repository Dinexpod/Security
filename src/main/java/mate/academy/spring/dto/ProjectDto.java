package mate.academy.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mate.academy.spring.model.Developer;
import mate.academy.spring.model.Project;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long projectId;
    private String projectName;
    private String projectType;
    private double projectCost;
    private LocalDateTime projectDate;

    public static ProjectDto doDtoProject(Project project) {
        ProjectDto projectDto = new ProjectDto();

        projectDto.setProjectId(project.getProjectId());
        projectDto.setProjectName(project.getProjectName());
        projectDto.setProjectType(project.getProjectType());
        projectDto.setProjectCost(project.getProjectCost());
        projectDto.setProjectDate(LocalDateTime.now());

        return projectDto;
    }
}
