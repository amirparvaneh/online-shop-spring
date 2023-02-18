package com.onlineshop.usermanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @JsonProperty("name")
    private String name;

    @JsonProperty("nationalId")
    private Long nationalID;

    @JsonProperty("role")
    private Role role;

    public User() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "national_ID")
    public Long getNationalID() {
        return nationalID;
    }

    public void setNationalID(Long nationalID) {
        this.nationalID = nationalID;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
