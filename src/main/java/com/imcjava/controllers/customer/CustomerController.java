package com.imcjava.controllers.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/login")
    public String login(){
        return "Customer login endpoint";
    }
    @GetMapping("/signup")
    public String signup(){
        return "Customer signup endpoint";
    }

}
