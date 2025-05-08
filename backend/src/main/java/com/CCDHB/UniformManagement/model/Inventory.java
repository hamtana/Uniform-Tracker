package com.CCDHB.UniformManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Inventory {

    @Id
    private String inventoryid;

    private String name;
    private String serialNumber;
    private BigDecimal cost;
    private int quantity_in_stock ;
    private String size;

    public String getinventoryid() {
        return inventoryid;
    }

    public int getquantity_in_stock() {
        return quantity_in_stock;
    }

    public void setquantity_in_stock(int quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public void setinventoryid(String inventoryId) {
        this.inventoryid = inventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
