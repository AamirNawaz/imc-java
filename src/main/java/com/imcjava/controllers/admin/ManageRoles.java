package com.imcjava.controllers.admin;

import com.imcjava.dto.RoleRequest;
import com.imcjava.dto.RoleResponse;
import com.imcjava.models.Role;
import com.imcjava.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class ManageRoles {
    private final IRoleService iRoleService;
    public ManageRoles(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    @PostMapping
    public RoleResponse createRole(@RequestBody RoleRequest roleRequest){
        return iRoleService.create(roleRequest);
    }

    @GetMapping
    public List<Role> getRoles(){
        return iRoleService.get();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id){
        return iRoleService.getRole(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id){
        return iRoleService.Delete(id);
    }


}
