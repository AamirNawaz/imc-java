package com.imcjava.repository;

import com.imcjava.models.ImcService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<ImcService, Long> {
    List<ImcService> findServicesByUserId(UUID loggedInUserId);

}
