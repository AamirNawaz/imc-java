package com.imcjava.services.sp_types;

import com.imcjava.dto.serviceProviderTypesDto.ServiceProviderTypesRequest;
import com.imcjava.dto.serviceProviderTypesDto.ServiceProviderTypesResponse;
import com.imcjava.models.ServiceProviderType;
import com.imcjava.repository.ServiceProviderTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISpTypesService implements SpTypesService {
     private final ServiceProviderTypeRepository spTypeRepo;

    public ISpTypesService(ServiceProviderTypeRepository spTypeRepo) {
        this.spTypeRepo = spTypeRepo;
    }

    @Override
    public ServiceProviderTypesResponse create(ServiceProviderTypesRequest serviceProviderTypesRequest) {
        ServiceProviderType newSpType = new ServiceProviderType();
        newSpType.setName(serviceProviderTypesRequest.getName());
        ServiceProviderType createdSpType = spTypeRepo.save(newSpType);
        return new ServiceProviderTypesResponse(createdSpType);
    }

    @Override
    public ServiceProviderTypesResponse update(Long id, ServiceProviderTypesRequest serviceProviderTypesRequest) {
        ServiceProviderType spType = spTypeRepo.findById(id).orElseThrow(()->new RuntimeException("No Record found!"));
        spType.setName(serviceProviderTypesRequest.getName());
        ServiceProviderType updatedSpType = spTypeRepo.save(spType);
        return new ServiceProviderTypesResponse(updatedSpType);



    }
    @Override
    public List<ServiceProviderType> get() {
        return spTypeRepo.findAll();
    }

    @Override
    public ServiceProviderType getById(Long id) {
        return spTypeRepo.findById(id).orElseThrow(()-> new RuntimeException("Record not found!"));
    }

    @Override
    public String Delete(Long id) {
        spTypeRepo.deleteById(id);
        return "Record No:"+id+" deleted successfully!";
    }


}
