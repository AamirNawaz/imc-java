package com.imcjava.services;


import com.imcjava.dto.RoleRequest;
import com.imcjava.dto.RoleResponse;
import com.imcjava.models.Role;

import java.util.List;

public interface RoleService {

    RoleResponse create(RoleRequest roleRequest);
    List<Role> get();

    Role getRole(Long id);

    String Delete(Long id);

}

