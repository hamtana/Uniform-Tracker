package com.CCDHB.UniformManagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long staffId;

    private String email;
    private String name;

    @ManyToOne
    @JoinColumn(name = "managerEmail", referencedColumnName = "email")
    private Manager manager;

    @OneToMany(mappedBy = "staff")
    private List<Orders> orders;

}
