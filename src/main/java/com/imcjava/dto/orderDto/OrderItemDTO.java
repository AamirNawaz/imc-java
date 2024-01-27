package com.imcjava.dto.orderDto;

import com.imcjava.models.ImcService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private Long orderQty;
    private ImcService serviceId;
}