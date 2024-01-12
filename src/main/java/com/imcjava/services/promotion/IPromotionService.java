package com.imcjava.services.promotion;

import com.imcjava.dto.promotionDto.PromotionRequest;
import com.imcjava.models.Promotion;
import com.imcjava.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPromotionService implements PromotionService {
    private final PromotionRepository promotionRepository ;

    public IPromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion create(PromotionRequest promotionRequest) {
        Promotion newPromotion = new Promotion();
        newPromotion.setType(promotionRequest.getType());
        newPromotion.setIsSent(promotionRequest.getIsSent());
        newPromotion.setUser(promotionRequest.getUser());
        newPromotion.setCreatedBy(promotionRequest.getCreatedBy());
        return promotionRepository.save(newPromotion);
    }

    @Override
    public List<Promotion> get() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion getById(Long id) {
        return promotionRepository.findById(id).orElseThrow(()->new RuntimeException("Record not found!"));
    }

    @Override
    public String Delete(Long id) {
        promotionRepository.deleteById(id);
         return "Record No:"+id+" deleted successfully!";
    }
}
