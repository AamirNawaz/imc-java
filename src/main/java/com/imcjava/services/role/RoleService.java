package com.imcjava.services.role;


import com.imcjava.dto.roleDto.RoleRequest;
import com.imcjava.dto.roleDto.RoleResponse;
import com.imcjava.models.Role;

import java.util.List;

public interface RoleService {

    RoleResponse create(RoleRequest roleRequest);

    List<Role> get();

    Role getById(Long id);

    String Delete(Long id);
}

