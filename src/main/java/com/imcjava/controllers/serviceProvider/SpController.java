package com.imcjava.controllers.serviceProvider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-provider")
public class SpController {
    public String signup(){
        return "Service Provider signup endpoint";
    }
}
