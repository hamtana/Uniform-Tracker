package com.CCDHB.UniformManagement.model;

import jakarta.persistence.*;

@Entity
public class Inventory_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "inventoryid", nullable = false)
    private Inventory inventory;

    private int quantity_ordered;
    private int quantity_fulfilled;

}
