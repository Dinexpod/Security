package mate.academy.spring.controller;

import lombok.extern.log4j.Log4j2;
import mate.academy.spring.dto.DeveloperDto;
import mate.academy.spring.model.Developer;
import mate.academy.spring.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/developer")
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String developer() {
        log.info("controller: DEVELOPER");
        return "developer/developer";
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index() {
//        log.info("controller: DEVELOPER INDEX");
//        return "/index";
//    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String developerInfo() {
        log.info("controller: DEVELOPER INFO");
        return "developer/info";
    }

    @RequestMapping(value = "/delete/{developerId}", method = RequestMethod.POST)
    public String developerDelete(@PathVariable Long developerId) {
        log.info("controller: DEVELOPER DELETE. Delete developer with id " + developerId + ".");
        developerService.delete(developerId);
        return "redirect:/developer/listDev";
    }

    @RequestMapping(value = "/{developerId}", method = RequestMethod.GET)
    public String getDeveloperInfo(@PathVariable Long developerId, ModelMap view) {
        log.info("controller: DEVELOPER INFO by id");
        DeveloperDto developerDto = developerService.getDeveloper(developerId);
        view.put("developer", developerDto);
        return "developer/info";
    }

    @RequestMapping(value = "/newDev", method = RequestMethod.GET)
    public ModelAndView newDeveloper() {
        log.info("controller: DEVELOPER newDev");
        return new ModelAndView("developer/createDeveloper", "developer", new Developer());
    }

    @RequestMapping(value = "/addDev", method = RequestMethod.POST)
    public String putDeveloper(DeveloperDto devDto, ModelMap model) {
        log.info("controller: DEVELOPER addDev");

        Developer dev = new Developer();

        dev.setDeveloperAge(devDto.getDeveloperAge());
        dev.setDeveloperSalary(devDto.getDeveloperSalary());
        dev.setDeveloperName(devDto.getDeveloperName());

        Developer developer = developerService.create(dev);
        Long id = developer.getDeveloperId();
        DeveloperDto developerDto = developerService.getDeveloper(id);

        model.put("developer", developerDto);
        return "developer/showDev";
    }

    @RequestMapping(value = "/listDev", method = RequestMethod.GET)
    public String listDeveloper(ModelMap model) {

        log.info("controller: DEVELOPER LIST");

        List<DeveloperDto> developers = developerService.getAll();

        model.put("developers", developers);
        return "developer/listDeveloper";
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Developer controller OK!");
    }
}
