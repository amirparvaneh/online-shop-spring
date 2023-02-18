package com.onlineshop.usermanagement.service.role;

import com.digi.microserviceusermanagement.model.entity.Role;
import com.digi.microserviceusermanagement.repository.role.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    @Override
    public void save(Role role) {
        roleRepo.save(role);
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> role = roleRepo.findById(id);
        return role.get();
    }

    @Override
    public void update(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void delete(Long id) {
        Role role = findById(id);
        roleRepo.delete(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }
}
