package com.imcjava.dto.promotionDto;

import com.imcjava.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PromotionRequest {
    private String type;
    private Boolean isSent;
    private User user;
    private User createdBy;
}
