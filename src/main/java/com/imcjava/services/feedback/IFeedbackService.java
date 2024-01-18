package com.imcjava.services.feedback;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;
import com.imcjava.models.User;
import com.imcjava.repository.FeedbackRepository;
import com.imcjava.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        User loggedInUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user with given id not exist!"));
        Feedback newFeedBack = new Feedback();
        newFeedBack.setMessage(feedbackRequest.getMessage());
        newFeedBack.setRating(feedbackRequest.getRating());
        newFeedBack.setRatedTo(feedbackRequest.getRatedTo());
        newFeedBack.setRatedBy(loggedInUser);
        return feedbackRepository.save(newFeedBack);
    }

    @Override
    public List<Feedback> get(UUID userId) {
        return feedbackRepository.findByRatedBy(userId);
    }

    @Override
    public Feedback getById(Long id) {
        return feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found!"));
    }

    @Override
    public String Delete(Long id) {
        feedbackRepository.deleteById(id);
        return "Record No:" + id + " deleted successfully!";
    }
}
