package com.imcjava.controllers.admin;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ManageServices {

    @PostMapping
    public String create(){
        return "Create service fun";
    }

//    @GetMapping
//    public
//    @PutMapping
//
//    @DeleteMapping
}
