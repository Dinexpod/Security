package mate.academy.spring.controller;

import mate.academy.spring.dto.DeveloperDto;
import mate.academy.spring.dto.ProjectDto;
import mate.academy.spring.model.Developer;
import mate.academy.spring.model.Project;
import mate.academy.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String developer() {
        return "project/project";
    }

    @RequestMapping(value = "/newProject", method = RequestMethod.GET)
    public ModelAndView newDeveloper() {
        return new ModelAndView("project/createProject", "project", new Project());
    }

    @RequestMapping(value = "/addDev", method = RequestMethod.POST)
    public String putDeveloper(ProjectDto projectDto, ModelMap model) {

        Project project = new Project();

        project.setProjectType(projectDto.getProjectName());
        project.setProjectName(projectDto.getProjectType());
        project.setProjectCost(projectDto.getProjectCost());

        Long id = projectService.create(project).getProjectId();
        ProjectDto projectDto1 = projectService.getProject(id);

        model.put("project", projectDto1);
        return "project/showProject";
    }

    @RequestMapping(value = "/listProject", method = RequestMethod.GET)
    public String listDeveloper(ModelMap model) {
        List<ProjectDto> projects = projectService.getAll();

        model.put("projects", projects);
        return "project/listProject";
    }
}
