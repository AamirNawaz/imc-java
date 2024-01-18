package com.imcjava.services.feedback;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;

import java.util.List;
import java.util.UUID;

public interface FeedbackService {
    Feedback create(UUID UserId, FeedbackRequest feedbackRequest);

    List<Feedback> get(UUID userId);

    Feedback getById(Long id);

    String Delete(Long id);
}
