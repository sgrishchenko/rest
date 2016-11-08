package com.example.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Developer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DeveloperPosition position;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private Set<Issue> issues;

    public Developer() {
    }

    public Developer(String name, DeveloperPosition position) {
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeveloperPosition getPosition() {
        return position;
    }

    public void setPosition(DeveloperPosition position) {
        this.position = position;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
