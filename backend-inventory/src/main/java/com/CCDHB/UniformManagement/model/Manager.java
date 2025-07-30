package com.CCDHB.UniformManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Manager {

    @Id
    private int managerId;

    private String email;
    private String name;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
