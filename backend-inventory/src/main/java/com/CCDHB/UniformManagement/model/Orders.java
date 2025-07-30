package com.CCDHB.UniformManagement.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {

    //Create Data Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String status;
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "staffEmail", referencedColumnName = "email")
    private Staff staff;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Inventory_Item> items;

}
