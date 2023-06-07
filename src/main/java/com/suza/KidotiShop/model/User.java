package com.suza.KidotiShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int UID;
    private String First_name;
    private String Last_name;
    private String Email;
    private String Username;
    private String Password;
    private String Privilege;
}
