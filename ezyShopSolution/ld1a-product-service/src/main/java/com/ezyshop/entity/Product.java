package com.ezyshop.entity;

import javax.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "Products", schema = "dbo")
@Data
public class Product {
    @Id
    @Column(name = "ProductId")
    private String productId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Category")
    private String category;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "IsDeleted")
    private boolean isDeleted;
}