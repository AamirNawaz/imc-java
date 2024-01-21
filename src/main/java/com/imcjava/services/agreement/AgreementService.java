package com.imcjava.services.agreement;

import com.imcjava.dto.agreementDto.AgreementRequest;
import com.imcjava.models.Agreement;

import java.util.List;
import java.util.UUID;

public interface AgreementService {
    Agreement create(AgreementRequest agreementRequest);

    List<Agreement> get(UUID userId);

    Agreement getById(Long id);

    String Delete(Long id);
}
