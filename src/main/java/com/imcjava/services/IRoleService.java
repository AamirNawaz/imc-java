package com.imcjava.services;

import com.imcjava.models.Role;
import com.imcjava.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleService implements RoleService {

    //constructor
    private final RoleRepository roleRepository;

    public IRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> get() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(Long id) {
        return roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role not found!"));
    }

    @Override
    public String Delete(Long id) {
         roleRepository.deleteById(id);
         return "Role deleted successfully!";
    }
}
