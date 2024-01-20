package com.imcjava.dto.agreementDto;

import com.imcjava.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AgreementRequest {
    private Boolean isAgreed;
    private User agreedWith;
}
