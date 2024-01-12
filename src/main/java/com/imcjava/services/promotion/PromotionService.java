package com.imcjava.services.promotion;

import com.imcjava.dto.promotionDto.PromotionRequest;
import com.imcjava.models.Promotion;
import java.util.List;

public interface PromotionService {
    Promotion create(PromotionRequest promotionRequest);
    List<Promotion> get();
    Promotion getById(Long id);
    String Delete(Long id);
}
