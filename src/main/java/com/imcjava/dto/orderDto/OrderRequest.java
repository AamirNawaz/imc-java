package com.imcjava.dto.orderDto;

import com.imcjava.models.ImcService;
import com.imcjava.models.User;
import com.imcjava.models.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String orderNumber;
    private Integer orderQty;
    private Boolean orderStatus;
    private User customerId;
    private Integer amount;
    private Boolean isPaid;
    private PaymentMode paymentMode;
    private Boolean isDeleted;
    private Integer contact;
    private String address;
    private List<ImcService> services;
}
