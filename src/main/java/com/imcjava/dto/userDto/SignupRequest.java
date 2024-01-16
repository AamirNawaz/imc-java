package com.imcjava.dto.userDto;

import com.imcjava.models.Qualification;
import com.imcjava.models.ServiceProviderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String name;
    private String email;
    private String password;
    private Boolean isDeleted;
    private Set<String> roles = new HashSet<>();
    private ServiceProviderType serviceProviderType;
    private Qualification qualificationId;
}

