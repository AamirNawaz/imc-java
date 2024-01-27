package com.imcjava.services.order;

import com.imcjava.dto.orderDto.OrderRequest;
import com.imcjava.dto.orderDto.OrderResponseDto;
import com.imcjava.models.Order;

import java.util.List;

public interface OrderService {
    Order create(OrderRequest orderRequest);

    List<OrderResponseDto> get();

    Order getById(Long id);

    String delete(Long id);
}
