package mate.academy.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.academy.spring.model.Developer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDto {

    private Long developerId;
    private String developerName;
    private Integer developerAge;
    private Integer developerSalary;

    public static DeveloperDto doDtoDev(Developer developer) {
        DeveloperDto devDto = new DeveloperDto();

        devDto.setDeveloperId(developer.getDeveloperId());
        devDto.setDeveloperAge(developer.getDeveloperAge());
        devDto.setDeveloperName(developer.getDeveloperName());
        devDto.setDeveloperSalary(developer.getDeveloperSalary());

        return devDto;
    }
}
