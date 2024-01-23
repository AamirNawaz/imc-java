package com.imcjava.services.order;

import com.imcjava.dto.orderDto.OrderRequest;
import com.imcjava.models.Order;
import com.imcjava.models.User;
import com.imcjava.repository.OrderRepository;
import com.imcjava.repository.UserRepository;
import com.imcjava.utils.CommonUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final CommonUtil commonUtil;
    private final UserRepository userRepository;

    public IOrderService(OrderRepository orderRepository, CommonUtil commonUtil, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.commonUtil = commonUtil;
        this.userRepository = userRepository;
    }

    @Override
    public Order create(OrderRequest orderRequest) {
        String customerId = commonUtil.getUserIdFromAuthentication();
        User fetchedUser = userRepository.findById(UUID.fromString(customerId)).orElseThrow(() -> new EntityNotFoundException("User not found!"));

        Order newOrder = new Order();
        newOrder.setOrderNumber(orderRequest.getOrderNumber());

        newOrder.setOrderStatus(orderRequest.getOrderStatus());
        newOrder.setCustomerId(fetchedUser);

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
