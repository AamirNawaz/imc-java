package com.imcjava.services.sp_service;

import com.imcjava.dto.serviceDto.ServiceRequest;
import com.imcjava.models.ServiceModel;

import java.util.List;

public interface SpService {
    ServiceModel create(ServiceRequest serviceRequest);
    List<ServiceModel> get();
    ServiceModel getById(Long id);
    String Delete(Long id);
}
