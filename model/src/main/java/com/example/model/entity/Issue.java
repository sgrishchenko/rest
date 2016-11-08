package com.example.model.entity;

import javax.persistence.*;

@Entity
public class Issue {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Integer estimate;

    @ManyToOne
    private Project project;
    @ManyToOne
    private Developer developer;

    public Issue() {
    }

    public Issue(String name, String description, Integer estimate) {
        this.name = name;
        this.description = description;
        this.estimate = estimate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
