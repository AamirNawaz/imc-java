package com.imcjava.controllers.admin;

import com.imcjava.models.User;
import com.imcjava.services.user.ImcUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class ManageUsers {
    private final ImcUserService imcUserService;

    public ManageUsers(ImcUserService imcUserService) {
        this.imcUserService = imcUserService;
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return imcUserService.getAllUsers();
    }
}
