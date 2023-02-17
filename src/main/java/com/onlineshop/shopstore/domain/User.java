package com.onlineshop.shopstore.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private String name;

    private String email;

    private String password;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
