package com.imcjava.controllers.admin;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;
import com.imcjava.services.feedback.IFeedbackService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/feedback")
public class ManageFeedback {
    private final IFeedbackService iFeedbackService;

    public ManageFeedback(IFeedbackService iFeedbackService) {
        this.iFeedbackService = iFeedbackService;
    }

    @PostMapping
    public Feedback createRole(@RequestBody FeedbackRequest feedbackRequest) {
        String userId = getUserIdFromAuthentication();

        return iFeedbackService.create(feedbackRequest);
    }

    @GetMapping
    public List<Feedback> get() {
        return iFeedbackService.get();
    }

    @GetMapping("/{id}")
    public Feedback getRole(@PathVariable Long id) {
        return iFeedbackService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        return iFeedbackService.Delete(id);
    }

    private String getUserIdFromAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getDetails() instanceof String) {
            return (String) authentication.getDetails();
        }
        // Handle the case where userId is not found, return null, or throw an exception as needed
        return null;
    }
}
