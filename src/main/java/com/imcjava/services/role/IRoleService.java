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
        try {
            if (!"admin".equals(roleRequest.getName())) {
                String capitalizeRoleName = "ROLE_" + roleRequest.getName().toUpperCase();

                Role role = new Role();
                role.setName(capitalizeRoleName);

                Role createdRole = roleRepository.save(role);

                // Making response
                RoleResponse roleResponse = new RoleResponse();
                roleResponse.setId(createdRole.getId());
                roleResponse.setName(capitalizeRoleName);
                roleResponse.setCreatedAt(createdRole.getCreatedAt());
                roleResponse.setUpdatedAt(createdRole.getUpdatedAt());

                return roleResponse;
            } else {
                // Handle case where name is "admin"
                RoleResponse roleResponse = new RoleResponse();
                return roleResponse;
            }
        } catch (RuntimeException e) {
            // Handle exception appropriately, for now returning a simple error message
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
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
