package entities.footbal;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    private String name;
   private Set<Continent> continent;
    private Set<Town> towns;

    public Country() {
    }

    @Column(name = "name", length = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country", targetEntity = Town.class)
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }

    @ManyToMany(mappedBy = "countries", targetEntity = Continent.class)
    public Set<Continent> getContinent() {
        return continent;
    }

    public void setContinent(Set<Continent> continent) {
        this.continent = continent;
    }
}
