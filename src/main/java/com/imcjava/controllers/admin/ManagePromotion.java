package com.imcjava.controllers.admin;

import com.imcjava.dto.promotionDto.PromotionRequest;
import com.imcjava.models.Promotion;
import com.imcjava.services.promotion.IPromotionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
public class ManagePromotion {
    private final IPromotionService iPromotionService;

    public ManagePromotion(IPromotionService iPromotionService) {
        this.iPromotionService = iPromotionService;
    }
    @PostMapping
    public Promotion createRole(@RequestBody PromotionRequest promotionRequest){
        return iPromotionService.create(promotionRequest);
    }

    @GetMapping
    public List<Promotion> get(){
        return iPromotionService.get();
    }

    @GetMapping("/{id}")
    public Promotion getById(@PathVariable Long id){
        return iPromotionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return iPromotionService.Delete(id);
    }
}
