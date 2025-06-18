package com.CCDHB.UniformManagement.controller;

import com.CCDHB.UniformManagement.model.Inventory;
import com.CCDHB.UniformManagement.repository.InventoryRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "*") // for development
public class InventoryController {

    private final InventoryRepository repository;

    public InventoryController(InventoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable String id) {
        Optional<Inventory> inventory = repository.findById(id);
        if (inventory.isPresent()) {
            return inventory.get();
        } else {
            throw new RuntimeException("Inventory item not found with ID: " + id);
        }
    }

    @GetMapping
    public List<Inventory> getAll(){
        return repository.findAll();
    }


    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return repository.save(inventory);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Inventory update(@PathVariable String id, @RequestBody Inventory updated) {
        return repository.findById(id)
                .map(inv -> {
                    inv.setquantity_in_stock(updated.getquantity_in_stock());
                    return repository.save(inv);
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }
}