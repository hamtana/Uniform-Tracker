package com.CCDHB.UniformManagement.controller;

import com.CCDHB.UniformManagement.model.Orders;
import com.CCDHB.UniformManagement.repository.OrdersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*") //for development purposes only.
public class OrdersController {

    // NEED TO ADD PRE-AUTH FOR ROLE ADMIN

    private final OrdersRepository repository;

    public OrdersController(OrdersRepository repository) {
        this.repository = repository;
    }

    // Retrieve all orders.
    @GetMapping
    public List<Orders> getAll() { return repository.findAll();}

    //Get Mapping for retrieving an order by ID
    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    // Post Mapping for Creating a New Order
    @PostMapping
    public Orders createOrder(@RequestBody Orders order){
        return repository.save(order);
    }

    // Put Mapping for Updating an Existing Order
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders updatedOrder) {
        return repository.findById(id)
                .map(order -> {
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setStatus(updatedOrder.getStatus());
                    order.setStaff(updatedOrder.getStaff());
                    order.setItems(updatedOrder.getItems());
                    return repository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }



}
