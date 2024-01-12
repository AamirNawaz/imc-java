package com.imcjava.dto.qualificationDto;

import com.imcjava.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QualificationRequest {
    private String qualification;
    private String experience;
    private User user;
}
