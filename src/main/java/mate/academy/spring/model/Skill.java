package mate.academy.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    private Name skillName;
    private Degree skillDegree;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "developerSkills")
    private Set<Developer> skillDevelopers;

    private enum Name {
        JAVA,
        RUBY,
        PHYTON
    }

    private enum Degree {
        JUNIOR,
        MIDDLE,
        SENIOR
    }

    public static Degree getDegreeSenior() {
        return Degree.SENIOR;
    }

    public static Degree getDegreeMiddle() {
        return Degree.MIDDLE;
    }

    public static Degree getDegreeJunior() {
        return Degree.JUNIOR;
    }

    public static Name getNameJava() {
        return Name.JAVA;
    }

    public static Name getNameRuby() {
        return Name.RUBY;
    }

    public static Name getNamePhyton() {
        return Name.PHYTON;
    }
}
