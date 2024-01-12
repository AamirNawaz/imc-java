package com.imcjava.services.order;

import com.imcjava.dto.orderDto.OrderRequest;
import com.imcjava.models.Order;

import java.util.List;

public interface OrderService {
    public Order create(OrderRequest orderRequest);
    public List<Order> get();
    public Order getById(Long id);
    public String delete(Long id);
}
