package com.onlineshop.usermanagement.controller;

import com.digi.microserviceusermanagement.model.entity.Permission;
import com.digi.microserviceusermanagement.service.permission.PermissionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/permissions")
public class PermissionController {

    private PermissionServiceImpl permissionService;

    public PermissionController(PermissionServiceImpl permissionService) {
        this.permissionService = permissionService;
    }


    @GetMapping(value = "/{id}")
    public Permission getPermission(@PathVariable Long id){
        Permission permission = new Permission();
        permission = permissionService.findById(id);
        return permission;
    }


    @PostMapping
    public String createPermission(@RequestBody Permission permission) {
        permissionService.save(permission);
        return permission.getTitle() + "have been saved";
    }

    @GetMapping
    public List<Permission> getAllPermission() {
        List<Permission> result = permissionService.findAll();
        return result;
    }

    @PutMapping
    public String updatePermission(@RequestParam Long id) {
        Permission permission = permissionService.findById(id);
        if (Objects.nonNull(permission)) {
            permissionService.update(permission);
        }
        return permission.getTitle() + "have been updated";
    }

    @DeleteMapping
    public String deletePermission(@RequestParam Long id) {
        permissionService.delete(id);
        return "permission with id : " + id + "have been deleted";
    }

}
