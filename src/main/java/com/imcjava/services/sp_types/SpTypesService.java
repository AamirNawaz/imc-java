package com.imcjava.services.sp_types;


import com.imcjava.dto.serviceProviderTypesDto.ServiceProviderTypesRequest;
import com.imcjava.dto.serviceProviderTypesDto.ServiceProviderTypesResponse;
import com.imcjava.models.ServiceProviderType;

import java.util.List;

public interface SpTypesService {

    ServiceProviderTypesResponse create(ServiceProviderTypesRequest serviceProviderTypesRequest);
    List<ServiceProviderType> get();
    ServiceProviderType getById(Long id);
    String Delete(Long id);
    ServiceProviderTypesResponse update(Long id,ServiceProviderTypesRequest serviceProviderTypesRequest);
}

