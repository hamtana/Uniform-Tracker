package com.CCDHB.UniformManagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long managerId;

    @Column(unique = true)
    private String email;

    private String name;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Staff> staffList;

}
