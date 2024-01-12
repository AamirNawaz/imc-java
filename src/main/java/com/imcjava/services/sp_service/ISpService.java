package com.imcjava.services.sp_service;

import com.imcjava.dto.serviceDto.ServiceRequest;
import com.imcjava.models.ServiceModel;
import com.imcjava.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISpService implements SpService {
    private final ServiceRepository serviceRepository;

    public ISpService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceModel create(ServiceRequest serviceRequest) {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setName(serviceRequest.getName());
        serviceModel.setCharges(serviceRequest.getCharges());
        serviceModel.setStatus(serviceRequest.getStatus());
        serviceModel.setImage(serviceRequest.getImage());
        serviceModel.setAvailableQty(serviceRequest.getAvailableQty());
        serviceModel.setTotalQty(serviceRequest.getTotalQty());
        serviceModel.setOrder(serviceRequest.getOrder());
        serviceModel.setUser(serviceRequest.getUser());
        return serviceRepository.save(serviceModel);
    }

    @Override
    public List<ServiceModel> get() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceModel getById(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found!"));
    }

    @Override
    public String Delete(Long id) {
        serviceRepository.deleteById(id);
        return "Record No:"+id+" deleted successfully!";
    }
}
