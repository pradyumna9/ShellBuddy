package com.pk.sellbuddy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "SELL_PRODUCT")
public class ProductEntity {
    @Id
    private String productId;
    private String name;
    private double cost;
}
