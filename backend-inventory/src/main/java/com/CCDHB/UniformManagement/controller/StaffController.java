package com.CCDHB.UniformManagement.controller;

import com.CCDHB.UniformManagement.model.Manager;
import com.CCDHB.UniformManagement.model.Staff;
import com.CCDHB.UniformManagement.repository.StaffRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin("*") // for development only.
public class StaffController {

    // NEED TO ADD PRE-AUTH FOR ROLE ADMIN

    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    // Add a POST Method to create a new staff member.
    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    // Add a Method to retrieve a staff member by Email.
    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff member not found with ID: " + id));
    }

    // Add a Delete method to delete a staff member by ID
    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        if (!staffRepository.existsById(id)) {
            throw new RuntimeException("Staff member not found with ID: " + id);
        }
        staffRepository.deleteById(id);
    }

    // Method to Update Staff Details
    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff updatedStaff) {
        return staffRepository.findById(id)
                .map(staff -> {
                    staff.setName(updatedStaff.getName());
                    staff.setEmail(updatedStaff.getEmail());
                    return staffRepository.save(staff);
                })
                .orElseThrow(() -> new RuntimeException("Staff member not found with ID: " + id));
    }



}
