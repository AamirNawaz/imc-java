package com.imcjava.controllers.admin;

import com.imcjava.dto.roleDto.RoleRequest;
import com.imcjava.dto.roleDto.RoleResponse;
import com.imcjava.models.Role;
import com.imcjava.services.role.IRoleService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/roles")
public class ManageRoles {
    private final IRoleService iRoleService;

    public ManageRoles(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    @PostMapping("/create")
    public RoleResponse createRole(@RequestBody RoleRequest roleRequest) {
        return iRoleService.create(roleRequest);
    }

    @GetMapping
    public List<Role> getRoles() {
        return iRoleService.get();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id) {
        return iRoleService.getById(id);
    }

    @Hidden
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        return iRoleService.Delete(id);
    }


}
