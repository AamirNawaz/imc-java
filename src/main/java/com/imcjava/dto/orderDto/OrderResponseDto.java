package com.imcjava.dto.orderDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imcjava.models.OrderItem;
import com.imcjava.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private String orderNumber;
    private Boolean orderStatus;
    private Integer amount;
    private Boolean isPaid;
    private String paymentMode;
    private Boolean isDeleted;
    private Integer contact;
    private String address;
    private List<OrderItem> orderItemList;
    @JsonIgnore
    private User customerId;
}
