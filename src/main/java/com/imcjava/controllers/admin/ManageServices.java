package com.imcjava.controllers.admin;

import com.imcjava.dto.serviceDto.ServiceRequest;
import com.imcjava.models.ImcService;
import com.imcjava.services.sp_service.ISpService;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<ImcService> get() {
        return iSpService.get();
    }

    @PreAuthorize("hasRole('SP')")
    @GetMapping("/get-my-services")
    public List<ImcService> getSpOwnService() {
        return iSpService.getMyService();
    }

    @GetMapping("/{id}")
    public ImcService getById(@PathVariable Long id) {
        return iSpService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return iSpService.Delete(id);
    }

}
