package softuni.workshop.data.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity{
    private String name;
    private Set<Project> projectSet;

    public Company() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }
}
