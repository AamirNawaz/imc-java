package com.imcjava.repository;

import com.imcjava.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findFeedbacksByRatedBy_Id(UUID userId);

    Optional<Feedback> findFeedbacksByIdAndRatedBy_Id(Long id, UUID userId);
}
