package com.imcjava.controllers.admin;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;
import com.imcjava.services.feedback.IFeedbackService;
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
}
