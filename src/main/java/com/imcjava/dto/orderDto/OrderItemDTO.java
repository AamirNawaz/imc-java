package com.imcjava.dto.orderDto;

import com.imcjava.dto.serviceDto.ServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private Long orderItemId;
    private ServiceRequest serviceRequest;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;
}