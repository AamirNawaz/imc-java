package com.imcjava.controllers.admin;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;
import com.imcjava.services.feedback.IFeedbackService;
import com.imcjava.utils.CommonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer/feedback")
public class ManageFeedback {
    private final IFeedbackService iFeedbackService;
    private final CommonUtil commonUtil;

    public ManageFeedback(IFeedbackService iFeedbackService, CommonUtil commonUtil) {
        this.iFeedbackService = iFeedbackService;
        this.commonUtil = commonUtil;
    }

    @PostMapping
    public Feedback createRole(@RequestBody FeedbackRequest feedbackRequest) {
        String currentUserId = commonUtil.getUserIdFromAuthentication();
        return iFeedbackService.create(UUID.fromString(currentUserId), feedbackRequest);
    }

    @GetMapping
    public List<Feedback> get() {
        String currentUserId = commonUtil.getUserIdFromAuthentication();
        return iFeedbackService.get(UUID.fromString(currentUserId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Feedback getById(@PathVariable Long id) {
        String currentUserId = commonUtil.getUserIdFromAuthentication();
        return iFeedbackService.getByIdAndUserId(id, UUID.fromString(currentUserId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        return iFeedbackService.Delete(id);
    }


}
