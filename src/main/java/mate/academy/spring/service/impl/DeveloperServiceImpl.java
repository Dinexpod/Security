package mate.academy.spring.service.impl;

import lombok.extern.log4j.Log4j;
import mate.academy.spring.dto.DeveloperDto;
import mate.academy.spring.model.Developer;
import mate.academy.spring.repository.DeveloperRepository;
import mate.academy.spring.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Component("developerService")
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public void create() {
        Developer developer = new Developer();

        developer.setDeveloperName("Din");
        developer.setDeveloperSalary(234234);
        developer.setDeveloperAge(22);

        developerRepository.save(developer);
    }

    @Override
    public Developer create(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    @Transactional(readOnly = true)
    public DeveloperDto getDeveloper(Long id) {
        Developer developer = developerRepository.getOne(id);
        return DeveloperDto.doDtoDev(developer);
    }

    @Override
    public List<DeveloperDto> getAll() {
        List<Developer> developers = developerRepository.findAll();
        return developers
                .stream()
                .map(DeveloperDto::doDtoDev)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        developerRepository.deleteById(id);
    }
}
