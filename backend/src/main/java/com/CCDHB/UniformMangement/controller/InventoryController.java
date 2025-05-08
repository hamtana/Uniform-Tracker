package com.CCDHB.UniformMangement.controller;

import com.CCDHB.UniformMangement.model.Inventory;
import com.CCDHB.UniformMangement.repository.InventoryRepository;
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

    // Get Inventory by inventoryId
//    @GetMapping("/{id}")
//    public Inventory getInventoryById(@PathVariable String id) {
//        Optional<Inventory> inventory = InventoryRepository.findById(id);
//        if (inventory.isPresent()) {
//            return inventory.get();
//        } else {
//            throw new RuntimeException("Inventory item not found with ID: " + id);
//        }
//    }

    @GetMapping
    public List<Inventory> getAll(){
        return repository.findAll();
    }


    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return repository.save(inventory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }


    @PutMapping("/{id}")
    public Inventory update(@PathVariable String id, @RequestBody Inventory updated) {
        return repository.findById(id)
                .map(inv -> {
                    inv.setName(updated.getName());
                    inv.setSerialNumber(updated.getSerialNumber());
                    inv.setCost(updated.getCost());
                    inv.setSize(updated.getSize());
                    return repository.save(inv);
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }
}