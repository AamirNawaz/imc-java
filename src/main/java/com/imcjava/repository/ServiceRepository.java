package com.imcjava.repository;

import com.imcjava.models.ImcService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ImcService, Long> {
}
