package com.imcjava.repository;

import com.imcjava.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceModel,Long> {
}
