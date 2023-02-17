package com.onlineshop.shopstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
