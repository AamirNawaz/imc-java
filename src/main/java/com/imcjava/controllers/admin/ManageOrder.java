package com.imcjava.controllers.admin;

import com.imcjava.dto.orderDto.OrderRequest;
import com.imcjava.models.Order;
import com.imcjava.services.order.IOrderService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/order")
@RequiredArgsConstructor
public class ManageOrder {
    private final IOrderService iOrderService;

    @PostMapping
    public Order create(@RequestBody OrderRequest orderRequest) {
        return iOrderService.create(orderRequest);
    }

    @GetMapping
    public List<Order> get() {
        return iOrderService.get();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return iOrderService.getById(id);
    }

    //@Hidden is used for Swagger to hide endpoint on swagger ui
    @Hidden
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return iOrderService.delete(id);
    }

}
