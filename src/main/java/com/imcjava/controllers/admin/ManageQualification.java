package com.imcjava.controllers.admin;

import com.imcjava.dto.qualificationDto.QualificationRequest;
import com.imcjava.models.Qualification;
import com.imcjava.services.qualification.IQualificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/qualification")
public class ManageQualification {
    private final IQualificationService iQualificationService;

    public ManageQualification(IQualificationService iQualificationService) {
        this.iQualificationService = iQualificationService;
    }

    @PostMapping
    public Qualification createRole(@RequestBody QualificationRequest qualificationRequest) {
        return iQualificationService.create(qualificationRequest);
    }

    @GetMapping
    public List<Qualification> get() {
        return iQualificationService.get();
    }

    @GetMapping("/{id}")
    public Qualification getById(@PathVariable Long id) {
        return iQualificationService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return iQualificationService.Delete(id);
    }
}
