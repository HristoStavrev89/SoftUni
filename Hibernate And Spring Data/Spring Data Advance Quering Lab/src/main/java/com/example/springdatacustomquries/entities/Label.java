package com.example.springdatacustomquries.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "labels")
public class Label {

    private long id;
    private String title;
    private String subTitle;
    private Set<Shampoo> shampoos;

    public Label() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title", unique = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "subtitle")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @OneToMany(mappedBy = "label", fetch = FetchType.EAGER)
    public Set<Shampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<Shampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
