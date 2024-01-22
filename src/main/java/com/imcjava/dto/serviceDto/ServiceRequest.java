package com.imcjava.dto.serviceDto;

import com.imcjava.models.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequest {
    private String name;
    private Integer charges;
    private String image;
    private Integer totalQty;
    private Integer availableQty;
    private Boolean status;
    private Order order;
}
