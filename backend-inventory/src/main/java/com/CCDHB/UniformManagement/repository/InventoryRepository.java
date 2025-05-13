package com.CCDHB.UniformManagement.repository;

import com.CCDHB.UniformManagement.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}