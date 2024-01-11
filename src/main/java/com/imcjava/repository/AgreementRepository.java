package com.imcjava.repository;

import com.imcjava.models.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement,Long> {
}
