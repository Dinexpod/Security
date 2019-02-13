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
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    private Type companyType;

    @ManyToMany
    @JoinTable(name="company_project")
    private Set<Project> companyProjects;

    protected enum Type {
        OUTSOURCE,
        INSOURCE
    }

    public static Type getTypeOutsource() {
        return Type.OUTSOURCE;
    }

    public static Type getTypeInsource() {
        return Type.INSOURCE;
    }
}
