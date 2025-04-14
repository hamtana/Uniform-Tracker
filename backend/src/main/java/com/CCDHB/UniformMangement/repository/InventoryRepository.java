package com.CCDHB.UniformMangement.repository;

import com.CCDHB.UniformMangement.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}