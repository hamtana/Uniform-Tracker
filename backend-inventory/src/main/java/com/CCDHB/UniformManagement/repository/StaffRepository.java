package com.CCDHB.UniformManagement.repository;

import com.CCDHB.UniformManagement.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Manager, Long> {
}
