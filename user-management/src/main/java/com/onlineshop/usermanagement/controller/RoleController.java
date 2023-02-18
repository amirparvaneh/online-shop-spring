package com.onlineshop.usermanagement.controller;

import com.digi.microserviceusermanagement.model.entity.Role;
import com.digi.microserviceusermanagement.service.role.RoleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long roleId) {
        return roleService.findById(roleId);
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        roleService.save(role);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(role);
    }

    @GetMapping
    public List<Role> getAllRole() {
        return roleService.findAll();
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        roleService.update(role);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(role);
    }

    @DeleteMapping
    public ResponseEntity<Role> deleteRoleById(@RequestParam Long roleId) {
        Role role = roleService.findById(roleId);
        roleService.delete(roleId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(role);
    }
}
