package com.imcjava.dto.qualificationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QualificationRequest {
    private String qualification;
    private String experience;
    private Long user;
}
