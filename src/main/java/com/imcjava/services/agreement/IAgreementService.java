package com.imcjava.services.agreement;

import com.imcjava.dto.agreementDto.AgreementRequest;
import com.imcjava.models.Agreement;
import com.imcjava.repository.AgreementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAgreementService implements AgreementService {
    private final AgreementRepository agreementRepository ;

    public IAgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Override
    public Agreement create(AgreementRequest agreementRequest) {
        Agreement newAgreement = new Agreement();
        newAgreement.setIsAgreed(agreementRequest.getIsAgreed());
        newAgreement.setUser(agreementRequest.getUser());
        newAgreement.setAgreedWith(agreementRequest.getAgreedWith());
        return agreementRepository.save(newAgreement);
    }

    @Override
    public List<Agreement> get() {
        return agreementRepository.findAll();
    }

    @Override
    public Agreement getById(Long id) {
        return agreementRepository.findById(id).orElseThrow(()->new RuntimeException("Record not found!"));
    }

    @Override
    public String Delete(Long id) {
        agreementRepository.deleteById(id);
         return "Record No:"+id+" deleted successfully!";
    }
}
