package com.onlineshop.shopstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "order-status")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus extends BaseEntity{

    private String name;
}
