package com.onlineshop.shopstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{


    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
