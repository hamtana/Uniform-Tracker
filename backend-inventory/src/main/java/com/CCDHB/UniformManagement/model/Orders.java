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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Inventory_Item> getItems() {
        return items;
    }

    public void setItems(List<Inventory_Item> items) {
        this.items = items;
    }
}
