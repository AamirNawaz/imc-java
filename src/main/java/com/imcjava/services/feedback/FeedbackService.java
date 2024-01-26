package com.imcjava.services.feedback;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;

import java.util.List;
import java.util.UUID;

public interface FeedbackService {
    Feedback create(UUID UserId, FeedbackRequest feedbackRequest);

    List<Feedback> get(UUID userId);
    

    String Delete(Long id);

    Feedback getByIdAndUserId(Long id, UUID userId);
}
