package com.onlineshop.shopstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    private LocalDateTime orderDate;

}
