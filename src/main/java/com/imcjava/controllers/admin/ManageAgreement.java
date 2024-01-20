package com.imcjava.controllers.admin;

import com.imcjava.dto.agreementDto.AgreementRequest;
import com.imcjava.models.Agreement;
import com.imcjava.services.agreement.IAgreementService;
import com.imcjava.utils.CommonUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/agreement")
public class ManageAgreement {
    private final IAgreementService iAgreementService;
    
    public ManageAgreement(IAgreementService iAgreementService, CommonUtil commonUtil) {
        this.iAgreementService = iAgreementService;
    }

    @PostMapping
    public Agreement create(@RequestBody AgreementRequest agreementRequest) {
        return iAgreementService.create(agreementRequest);
    }

    @GetMapping
    public List<Agreement> get() {
        return iAgreementService.get();
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
