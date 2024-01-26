package com.imcjava.services.feedback;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;
import com.imcjava.models.User;
import com.imcjava.repository.FeedbackRepository;
import com.imcjava.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class IFeedbackService implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    public IFeedbackService(FeedbackRepository feedbackRepository, UserRepository userRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Feedback create(UUID userId, FeedbackRequest feedbackRequest) {
        UUID ratedToUserId = feedbackRequest.getRatedTo().getId();
        List<User> users = userRepository.findByIdIn(Arrays.asList(userId, ratedToUserId));
        if (users.size() < 2) {
            throw new EntityNotFoundException("One or both users with given id not found");
        }

        User loggedInUser = users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Logged in user not found"));

        User ratedToUser = users.stream()
                .filter(user -> user.getId().equals(ratedToUserId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Rated to user not found"));

        Feedback newFeedback = new Feedback();
        newFeedback.setMessage(feedbackRequest.getMessage());
        newFeedback.setRating(feedbackRequest.getRating());
        newFeedback.setRatedTo(ratedToUser);
        newFeedback.setRatedBy(loggedInUser);

        return feedbackRepository.save(newFeedback);
    }

    @Override
    public List<Feedback> get(UUID userId) {
        return feedbackRepository.findFeedbacksByRatedBy_Id(userId);
    }

    @Override
    public Feedback getByIdAndUserId(Long id, UUID userId) {
        return feedbackRepository.findFeedbacksByIdAndRatedBy_Id(id, userId).orElseThrow(() -> new RuntimeException("Feedback not found against UserId:" + userId));
    }

    @Override
    public String Delete(Long id) {
        feedbackRepository.deleteById(id);
        return "Record No:" + id + " deleted successfully!";
    }

}
