package com.imcjava.services.order;

import com.imcjava.dto.orderDto.OrderRequest;
import com.imcjava.models.Order;
import com.imcjava.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrderService implements OrderService {
    private final OrderRepository orderRepository;

    public IOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(OrderRequest orderRequest) {
        Order newOrder = new Order();
        newOrder.setOrderNumber(orderRequest.getOrderNumber());
        newOrder.setOrderStatus(orderRequest.getOrderStatus());
        newOrder.setCustomerId(orderRequest.getCustomerId());
        newOrder.setAddress(orderRequest.getAddress());
        newOrder.setAmount(orderRequest.getAmount());
        newOrder.setContact(orderRequest.getContact());
        newOrder.setIsPaid(false);
        newOrder.setIsDeleted(false);
        return orderRepository.save(newOrder);
    }

    @Override
    public List<Order> get() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found!"));
    }

    @Override
    public String delete(Long id) {
        orderRepository.deleteById(id);
        return "Record No:" + id + "deleted successfully!";
    }
}
