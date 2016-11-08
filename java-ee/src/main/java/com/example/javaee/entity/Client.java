package com.example.javaee.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement(name="Client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    @Id
    @GeneratedValue
    @XmlAttribute
    private Long id;
    @XmlElement
    private String name;
    @Enumerated(EnumType.STRING)
    @XmlElement
    private ClientType type;

    public Client() {
    }

    public Client(String name, ClientType type) {
        this.name = name;
        this.type = type;
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

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }
}