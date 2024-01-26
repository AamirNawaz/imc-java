package com.imcjava.services.sp_service;

import com.imcjava.dto.serviceDto.ServiceRequest;
import com.imcjava.models.ImcService;
import com.imcjava.models.User;
import com.imcjava.repository.ServiceRepository;
import com.imcjava.repository.UserRepository;
import com.imcjava.utils.CommonUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ISpService implements SpService {
    private final ServiceRepository serviceRepository;
    private final CommonUtil commonUtil;
    private final UserRepository userRepository;

    public ISpService(ServiceRepository serviceRepository, CommonUtil commonUtil, UserRepository userRepository) {
        this.serviceRepository = serviceRepository;
        this.commonUtil = commonUtil;
        this.userRepository = userRepository;
    }

    @Override
    public ImcService create(ServiceRequest serviceRequest) {
        String loggedInUserId = commonUtil.getUserIdFromAuthentication();
        User fetchedUser = userRepository.findById(UUID.fromString(loggedInUserId)).orElseThrow(() -> new EntityNotFoundException("User not found!"));

        ImcService ImcService = new ImcService();
        ImcService.setName(serviceRequest.getName());
        ImcService.setCharges(serviceRequest.getCharges());
        ImcService.setStatus(serviceRequest.getStatus());
        ImcService.setImage(serviceRequest.getImage());
        ImcService.setTotalQty(serviceRequest.getTotalQty());
        ImcService.setUser(fetchedUser);
        return serviceRepository.save(ImcService);
    }

    @Override
    public List<ImcService> get() {
        return serviceRepository.findAll();
    }

    @Override
    public ImcService getById(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found!"));
    }

    @Override
    public String Delete(Long id) {
        serviceRepository.deleteById(id);
        return "Record No:" + id + " deleted successfully!";
    }

    public List<ImcService> getMyService() {
        String loggedInUserId = commonUtil.getUserIdFromAuthentication();
        return serviceRepository.findServicesByUserId(UUID.fromString(loggedInUserId));
    }
}
