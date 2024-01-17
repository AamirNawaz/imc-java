package com.imcjava.controllers.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/order")
public class CustomerOrder {


    @PostMapping("/placeOrder")
    public String placeOrder() {
        return "Post request - place order";
    }

    @GetMapping("/trackOrder")
    public String trackOrderNow() {
        return "Tracking order by ordernumber";
    }
}
