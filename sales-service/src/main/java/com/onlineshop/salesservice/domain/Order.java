package com.onlineshop.salesservice.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "order")
@Data
@Setter
@Getter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;
    // constructors, getters, and setters
}
