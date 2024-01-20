package com.imcjava.services.role;

import com.imcjava.dto.roleDto.RoleRequest;
import com.imcjava.dto.roleDto.RoleResponse;
import com.imcjava.models.Role;
import com.imcjava.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleService implements RoleService {
    private final RoleRepository roleRepository;

    public IRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponse create(RoleRequest roleRequest) {
        String capitalizeRoleName = "ROLE_" + roleRequest.getName().toUpperCase();
        Role role = new Role();
        role.setName(roleRequest.getName());
        Role createdRole = roleRepository.save(role);

        //making response
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(createdRole.getId());
        roleResponse.setName(capitalizeRoleName);
        roleResponse.setCreatedAt(createdRole.getCreatedAt());
        roleResponse.setUpdatedAt(createdRole.getUpdatedAt());
        return roleResponse;
    }

    @Override
    public List<Role> get() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found!"));
    }

    @Override
    public String Delete(Long id) {
        roleRepository.deleteById(id);
        return "Record No:" + id + " deleted successfully!";
    }
}
