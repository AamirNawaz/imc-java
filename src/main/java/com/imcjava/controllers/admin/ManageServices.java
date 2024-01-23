package com.imcjava.controllers.admin;

import com.imcjava.dto.serviceDto.ServiceRequest;
import com.imcjava.models.ImcService;
import com.imcjava.services.sp_service.ISpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-provider/service")
public class ManageServices {

    private final ISpService iSpService;

    public ManageServices(ISpService iSpService) {
        this.iSpService = iSpService;
    }

    @PostMapping
    public ImcService create(@RequestBody ServiceRequest serviceRequest) {
        return iSpService.create(serviceRequest);
    }

    @GetMapping
    public List<ImcService> get() {
        return iSpService.get();
    }

    @GetMapping("/{id}")
    public ImcService getById(@PathVariable Long id) {
        return iSpService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return iSpService.Delete(id);
    }

}
