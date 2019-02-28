package mate.academy.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long developerId;
    private String developerName;
    private Integer developerAge;
    private Integer developerSalary;

    @ManyToMany
    @JoinTable(name="developer_project")
    private Set<Project> developerProjects;

    @ManyToMany
    @JoinTable(name="developer_skill")
    private Set<Skill> developerSkills;
}
