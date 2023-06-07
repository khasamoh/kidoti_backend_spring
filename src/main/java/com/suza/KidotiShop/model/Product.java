package com.suza.KidotiShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int ProID;
    private String Pro_name;
    private int Buy_price;
    private int Sale_price;
    private int Quantity;
}
