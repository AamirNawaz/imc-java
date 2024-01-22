package com.imcjava.controllers.admin;

import com.imcjava.dto.agreementDto.AgreementRequest;
import com.imcjava.models.Agreement;
import com.imcjava.services.agreement.IAgreementService;
import com.imcjava.utils.CommonUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agreement")
public class ManageAgreement {
    private final IAgreementService iAgreementService;
    private final CommonUtil commonUtil;

    public ManageAgreement(IAgreementService iAgreementService, CommonUtil commonUtil, CommonUtil commonUtil1) {
        this.iAgreementService = iAgreementService;
        this.commonUtil = commonUtil1;
    }

    @PostMapping
    public Agreement create(@RequestBody AgreementRequest agreementRequest) {
        return iAgreementService.create(agreementRequest);
    }

    @GetMapping
    public List<Agreement> get() {
        String loggedInUserId = commonUtil.getUserIdFromAuthentication();
        return iAgreementService.get(UUID.fromString(loggedInUserId));
    }

    @GetMapping("/{id}")
    public Agreement getById(@PathVariable Long id) {
        return iAgreementService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return iAgreementService.Delete(id);
    }
}
