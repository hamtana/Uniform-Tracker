package com.CCDHB.UniformManagement.controller;

import com.CCDHB.UniformManagement.model.Manager;
import com.CCDHB.UniformManagement.repository.ManagerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/manager")
@CrossOrigin("*") // for dev
public class ManagerController {

    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    // Method to Create New Manager
    @PostMapping
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    // Method to Retrieve Manager by ID
    @PostMapping("/{id}")
    public Manager getManagerById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + id));
    }

    // Method to update manager details
    @PutMapping("/{id}")
    public Manager updateManager(@PathVariable Long id, @RequestBody Manager updatedManager) {
        return managerRepository.findById(id)
                .map(manager -> {
                    manager.setName(updatedManager.getName());
                    manager.setEmail(updatedManager.getEmail());
                    return managerRepository.save(manager);
                })
                .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + id));
    }

    // Method to delete a Manager by ID
    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        if (!managerRepository.existsById(id)) {
            throw new RuntimeException("Manager not found with ID: " + id);
        }
        managerRepository.deleteById(id);
    }
}
