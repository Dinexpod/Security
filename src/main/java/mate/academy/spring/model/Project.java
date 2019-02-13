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
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectName;
    private String projectType;
    private double projectCost;
    private LocalDateTime projectDate;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "developerProjects")
    private Set<Developer> projectDevelopers;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "companyProjects")
    private Set<Company> projectCompanies;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "customerProjects")
    private Set<Customer> projectCustomers;
}
