package com.CCDHB.UniformManagement.repository;

import com.CCDHB.UniformManagement.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
