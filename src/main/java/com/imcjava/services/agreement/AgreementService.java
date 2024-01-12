package com.imcjava.services.agreement;

import com.imcjava.dto.agreementDto.AgreementRequest;
import com.imcjava.models.Agreement;

import java.util.List;

public interface AgreementService {
    Agreement create(AgreementRequest agreementRequest);
    List<Agreement> get();
    Agreement getById(Long id);
    String Delete(Long id);
}
