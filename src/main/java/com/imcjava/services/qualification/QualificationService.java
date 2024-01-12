package com.imcjava.services.qualification;

import com.imcjava.dto.qualificationDto.QualificationRequest;
import com.imcjava.models.Qualification;

import java.util.List;

public interface QualificationService {
    Qualification create(QualificationRequest qualificationRequest);
    List<Qualification> get();
    Qualification getById(Long id);
    String Delete(Long id);
}
