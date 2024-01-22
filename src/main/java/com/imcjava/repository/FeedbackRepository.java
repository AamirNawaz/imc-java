package com.imcjava.repository;

import com.imcjava.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "select * from feedbacks where rated_by = :userId", nativeQuery = true)
    List<Feedback> findByRatedBy(@Param("userId") UUID userId);
}
