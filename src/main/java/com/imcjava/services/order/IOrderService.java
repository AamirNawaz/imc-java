package com.imcjava.services.order;

import com.imcjava.dto.orderDto.OrderItemDTO;
import com.imcjava.dto.orderDto.OrderRequest;
import com.imcjava.models.Order;
import com.imcjava.models.OrderItem;
import com.imcjava.models.User;
import com.imcjava.repository.OrderRepository;
import com.imcjava.repository.UserRepository;
import com.imcjava.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class IOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CommonUtil commonUtil;

    public IOrderService(OrderRepository orderRepository, UserRepository userRepository, CommonUtil commonUtil) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.commonUtil = commonUtil;
    }

    @Override
    public Order create(OrderRequest orderRequest) {
        String currentUserId = commonUtil.getUserIdFromAuthentication();
        User loggedInUser = userRepository.findById(UUID.fromString(currentUserId)).orElseThrow(() -> new RuntimeException("user with given id not exist!"));
        Order newOrder = new Order();
        newOrder.setOrderNumber(UUID.randomUUID().toString());
        newOrder.setOrderStatus(true);
        newOrder.setAddress(orderRequest.getAddress());
        newOrder.setContact(orderRequest.getContact());
        newOrder.setCustomerId(loggedInUser);
        newOrder.setPaymentMode(orderRequest.getPaymentMode());
        newOrder.setIsPaid(false);
        newOrder.setIsDeleted(false);
        List<OrderItem> orderItems = orderRequest.getOrderItemsDtoList().stream().map(this::mapToDto).toList();
        newOrder.setOrderItemList(orderItems);

        //calculating order total amount
        double totalOrderAmount = orderItems.stream()
                .mapToDouble(OrderItem::getOrderAmount)
                .sum();
        newOrder.setAmount((int) totalOrderAmount);

        return orderRepository.save(newOrder);

    }

    private OrderItem mapToDto(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setTotalQty(orderItemDTO.getTotalQty());
        orderItem.setSkuCode(orderItemDTO.getSkuCode());
        orderItem.setOrderAmount(orderItemDTO.getOrderAmount());
        return orderItem;
    }

    @Override
    public List<Order> get() {
        List<Order> orders = new ArrayList<>();
        try {
            orders = orderRepository.findAll();
        } catch (AuthenticationException | AccessDeniedException e) {
            log.error("Spring Security Exception: " + e.getMessage(), e);
            // Handle the Spring Security exception, return an appropriate response, or rethrow it if needed
        } catch (RuntimeException e) {
            log.error("Runtime Exception: " + e.getMessage(), e);
            // Handle other runtime exceptions
        }
        return orders;
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
