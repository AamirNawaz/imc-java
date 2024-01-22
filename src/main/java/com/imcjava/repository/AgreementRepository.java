package com.imcjava.repository;

import com.imcjava.models.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
    List<Agreement> findAllByUserId(UUID userId);
}
