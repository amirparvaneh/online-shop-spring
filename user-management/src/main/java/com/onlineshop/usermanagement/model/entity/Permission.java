package com.onlineshop.usermanagement.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {

    @Column(name = "permission_title")
    @JsonProperty("title")
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        System.out.println(this.title + "\n");
        return this.title + "\n";
    }
}
