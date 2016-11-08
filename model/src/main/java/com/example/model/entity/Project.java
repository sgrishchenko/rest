package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate deadline;

    @OneToOne(mappedBy="project", optional=false)
    @JsonBackReference
    private Contract contract;

    public Project() {
    }

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Issue> issues;

    public Project(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
