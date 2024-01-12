package com.imcjava.controllers.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public String signup(){
        return "Customer signup endpoint";
    }
}
