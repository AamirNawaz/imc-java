package com.imcjava.dto.serviceDto;

import com.imcjava.models.Order;
import com.imcjava.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
