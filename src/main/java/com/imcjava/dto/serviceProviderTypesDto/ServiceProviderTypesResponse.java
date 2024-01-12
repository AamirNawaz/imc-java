package com.imcjava.dto.serviceProviderTypesDto;

import com.imcjava.models.ServiceProviderType;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ServiceProviderTypesResponse {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ServiceProviderTypesResponse(ServiceProviderType serviceProviderType){
        this.id = serviceProviderType.getId();
        this.name = serviceProviderType.getName();
        this.createdAt = serviceProviderType.getCreatedAt();
        this.updatedAt = serviceProviderType.getUpdatedAt();

    }
}
