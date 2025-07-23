package com.CCDHB.UniformManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Staff {

    @Id
    private String email;

    private String name;
    // Add reference to Manager.
}
