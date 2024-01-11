package com.imcjava.services.feedback;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback create(FeedbackRequest feedbackRequest);
    List<Feedback> get();
    Feedback getById(Long id);
    String Delete(Long id);
}
