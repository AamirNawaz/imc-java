package com.imcjava.services.sp_service;

import com.imcjava.dto.serviceDto.ServiceRequest;
import com.imcjava.models.ImcService;

import java.util.List;

public interface SpService {
    ImcService create(ServiceRequest serviceRequest);

    List<ImcService> get();

    ImcService getById(Long id);

    String Delete(Long id);
}
