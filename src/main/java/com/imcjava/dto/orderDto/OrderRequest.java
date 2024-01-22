package com.imcjava.dto.orderDto;

import com.imcjava.models.ServiceModel;
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
    private Integer amount;
    private Boolean isPaid;
    private String paymentMode;
    private Boolean isDeleted;
    private Integer contact;
    private String address;
    private List<ServiceModel> services;
}
