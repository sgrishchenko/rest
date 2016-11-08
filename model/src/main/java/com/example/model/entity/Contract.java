package com.example.model.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Contract {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private BigDecimal budget;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Project project;
    @ManyToMany(mappedBy = "contracts")
    private Set<Client> clients;

    public Contract() {
    }

    public Contract(String description, BigDecimal budget) {
        this.description = description;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
