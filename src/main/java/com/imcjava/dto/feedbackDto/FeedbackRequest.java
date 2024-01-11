package com.imcjava.dto.feedbackDto;

import com.imcjava.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedbackRequest {
    private String message;
    private User ratedTo;
    private User ratedBy;
    private Integer rating;
}
