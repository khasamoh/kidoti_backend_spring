package com.suza.KidotiShop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int SlID;
    private String SalDate;
    private int SalQuantity;
    private String PayStatus;
    @ManyToOne
    @JoinColumn(name = "ProID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "CustID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "UID")
    private User user ;
}
