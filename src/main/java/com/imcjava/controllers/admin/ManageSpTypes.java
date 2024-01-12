package com.imcjava.controllers.admin;

import com.imcjava.dto.serviceProviderTypesDto.ServiceProviderTypesRequest;
import com.imcjava.dto.serviceProviderTypesDto.ServiceProviderTypesResponse;
import com.imcjava.models.ServiceProviderType;
import com.imcjava.services.sp_types.ISpTypesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sp-types")
public class ManageSpTypes {
    private final ISpTypesService iSpTypesService;

    public ManageSpTypes(ISpTypesService iSpTypesService) {
        this.iSpTypesService = iSpTypesService;
    }

    @PostMapping
    public ServiceProviderTypesResponse create(@RequestBody ServiceProviderTypesRequest spRequest){
        return iSpTypesService.create(spRequest);
    }

    @GetMapping
    public List<ServiceProviderType> get(){
        return iSpTypesService.get();
    }

    @GetMapping("/{id}")
    public ServiceProviderType getById(@PathVariable Long id){
        return iSpTypesService.getById(id);
    }

    @PutMapping("/{id}")
    public ServiceProviderTypesResponse update(@PathVariable Long id,@RequestBody ServiceProviderTypesRequest serviceProviderTypesRequest){
        return iSpTypesService.update(id,serviceProviderTypesRequest);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return iSpTypesService.Delete(id);
    }

}
