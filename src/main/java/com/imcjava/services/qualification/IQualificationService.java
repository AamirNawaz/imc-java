package com.imcjava.services.qualification;

import com.imcjava.dto.qualificationDto.QualificationRequest;
import com.imcjava.models.Qualification;
import com.imcjava.repository.QualificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IQualificationService implements QualificationService {
    private final QualificationRepository qualificationRepository ;

    public IQualificationService(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }
    @Override
    public Qualification create(QualificationRequest qualificationRequest) {
        Qualification newQualification = new Qualification();
        newQualification.setQualification(qualificationRequest.getQualification());
        newQualification.setUser(qualificationRequest.getUser());
        newQualification.setExperience(qualificationRequest.getExperience());
        return qualificationRepository.save(newQualification);
    }

    @Override
    public List<Qualification> get() {
        return qualificationRepository.findAll();
    }

    @Override
    public Qualification getById(Long id) {
        return qualificationRepository.findById(id).orElseThrow(()->new RuntimeException("Record not found!"));
    }

    @Override
    public String Delete(Long id) {
        qualificationRepository.deleteById(id);
         return "Record No:"+id+" deleted successfully!";
    }
}
