package com.onlineshop.usermanagement.service.permission;

import com.digi.microserviceusermanagement.model.entity.Permission;
import com.digi.microserviceusermanagement.repository.permission.PermissionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService{

    private PermissionRepo permissionRepo;

    public PermissionServiceImpl(PermissionRepo permissionRepo){
        this.permissionRepo = permissionRepo;
    }
    @Override
    public void save(Permission permission) {
        permissionRepo.save(permission);
    }

    @Override
    public Permission findById(Long id) {
        Optional<Permission> permission = permissionRepo.findById(id);
        return permission.get();
    }

    @Override
    public void update(Permission permission) {
        permissionRepo.save(permission);
    }

    @Override
    public void delete(Long id) {
        Optional<Permission> permission = permissionRepo.findById(id);
        permissionRepo.delete(permission.get());
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepo.findAll();
    }
}
