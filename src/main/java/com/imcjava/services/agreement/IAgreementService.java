package com.imcjava.services.agreement;

import com.imcjava.dto.agreementDto.AgreementRequest;
import com.imcjava.models.Agreement;
import com.imcjava.models.User;
import com.imcjava.repository.AgreementRepository;
import com.imcjava.repository.UserRepository;
import com.imcjava.utils.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IAgreementService implements AgreementService {
    private final AgreementRepository agreementRepository;
    private final CommonUtil commonUtil;
    private final UserRepository userRepository;

    public IAgreementService(AgreementRepository agreementRepository, CommonUtil commonUtil, UserRepository userRepository) {
        this.agreementRepository = agreementRepository;
        this.commonUtil = commonUtil;
        this.userRepository = userRepository;
    }

    @Override
    public Agreement create(AgreementRequest agreementRequest) {
        String currentUserId = commonUtil.getUserIdFromAuthentication();
        User fetchedUser = userRepository.findById(UUID.fromString(currentUserId)).orElseThrow(() -> new RuntimeException("user with given id not exist!"));
        Agreement newAgreement = new Agreement();
        newAgreement.setIsAgreed(agreementRequest.getIsAgreed());
        newAgreement.setUser(fetchedUser);
        newAgreement.setAgreedWith(agreementRequest.getAgreedWith());
        return agreementRepository.save(newAgreement);
    }

    @Override
    public List<Agreement> get() {
        return agreementRepository.findAll();
    }

    @Override
    public Agreement getById(Long id) {
        return agreementRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found!"));
    }

    @Override
    public String Delete(Long id) {
        agreementRepository.deleteById(id);
        return "Record No:" + id + " deleted successfully!";
    }
}
