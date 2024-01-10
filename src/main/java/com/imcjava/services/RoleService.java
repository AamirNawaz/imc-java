package com.imcjava.services;


import com.imcjava.dto.RoleRequest;
import com.imcjava.models.Role;

import java.util.List;

public interface RoleService {

    Role create(Role role);
    List<Role> get();

    Role getRole(Long id);

    String Delete(Long id);

}

