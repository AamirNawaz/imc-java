package com.imcjava.services.order;

import com.imcjava.dto.orderDto.OrderItemDTO;
import com.imcjava.dto.orderDto.OrderRequest;
import com.imcjava.dto.orderDto.OrderResponseDto;
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
        return orderRepository.save(newOrder);

    }

    private OrderItem mapToDto(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setServiceId(orderItemDTO.getServiceId());
        orderItem.setOrderQty(orderItemDTO.getOrderQty());
        return orderItem;
    }


    @Override
    public List<OrderResponseDto> get() {
        List<OrderResponseDto> ordersDtoList = new ArrayList<>();
        try {
            List<Order> orders = orderRepository.findAll();
            for (Order order : orders) {
                OrderResponseDto orderDto = mapToOrderResponseDto(order);
                ordersDtoList.add(orderDto);
            }
        } catch (AccessDeniedException e) {
            log.error("Access Denied Exception: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            log.error("Runtime Exception: " + e.getMessage(), e);
        }
        return ordersDtoList;
    }


    private OrderResponseDto mapToOrderResponseDto(Order order) {
        OrderResponseDto orderDto = new OrderResponseDto();
        orderDto.setId(order.getId());
        orderDto.setOrderNumber(order.getOrderNumber());
        orderDto.setOrderStatus(order.getOrderStatus());
        orderDto.setAmount(order.getAmount());
        orderDto.setIsPaid(order.getIsPaid());
        orderDto.setPaymentMode(order.getPaymentMode());
        orderDto.setIsDeleted(order.getIsDeleted());
        orderDto.setContact(order.getContact());
        orderDto.setAddress(order.getAddress());
        orderDto.setOrderItemList(order.getOrderItemList());
        orderDto.setCustomerId(order.getCustomerId());
        return orderDto;
    }

    @Override
    public Order getById(Long id) {
        String loggedInUser = commonUtil.getUserIdFromAuthentication();
        User user = userRepository.findById(UUID.fromString(loggedInUser)).orElseThrow(() -> new RuntimeException("user with given id not exist!"));
        return orderRepository.findOrderByIdAndCustomerId(id, user).orElseThrow(() -> new RuntimeException("Record not found!"));
    }

    @Override
    public String delete(Long id) {
        String loggedInUser = commonUtil.getUserIdFromAuthentication();
        User user = userRepository.findById(UUID.fromString(loggedInUser)).orElseThrow(() -> new RuntimeException("user with given id not exist!"));
        orderRepository.deleteOrderByIdAndCustomerId(id, user);
        return "Record No:" + id + "deleted successfully!";
    }

    public List<OrderResponseDto> getMyOrders() {
        String loggedInUser = commonUtil.getUserIdFromAuthentication();
        User user = userRepository.findById(UUID.fromString(loggedInUser)).orElseThrow(() -> new RuntimeException("user with given id not exist!"));
        List<OrderResponseDto> fetchOrders = new ArrayList<>();
        try {
            List<Order> orders = orderRepository.findOrdersByCustomerId(user);
            for (Order order : orders) {
                OrderResponseDto orderDto = mapToOrderResponseDto(order);
                fetchOrders.add(orderDto);
            }
        } catch (AuthenticationException | AccessDeniedException e) {
            log.error("Spring Security Exception: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            log.error("Runtime Exception: " + e.getMessage(), e);
        }
        
        return fetchOrders;

    }
}
