package com.imcjava.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Boolean orderStatus;
    private Integer contact;
    private String address;
    private String paymentMode;
    private List<OrderItemDTO> orderItemsDtoList;
}
