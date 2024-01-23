package com.imcjava.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String orderNumber;
    private Boolean orderStatus;
    private Integer amount;
    private Boolean isPaid;
    private Boolean isDeleted;
    private Integer contact;
    private String address;
    private List<OrderItemDTO> orderItems = new ArrayList<>();
}
