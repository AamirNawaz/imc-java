package com.imcjava.services.feedback;

import com.imcjava.dto.feedbackDto.FeedbackRequest;
import com.imcjava.models.Feedback;
import com.imcjava.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFeedbackService implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public IFeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback create(FeedbackRequest feedbackRequest) {
        Feedback newFeedBack = new Feedback();
        newFeedBack.setMessage(feedbackRequest.getMessage());
        newFeedBack.setRating(feedbackRequest.getRating());
        newFeedBack.setRatedTo(feedbackRequest.getRatedTo());
        newFeedBack.setRatedBy(feedbackRequest.getRatedBy());
        return feedbackRepository.save(newFeedBack);
    }

    @Override
    public List<Feedback> get() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getById(Long id) {
        return feedbackRepository.findById(id).orElseThrow(()->new RuntimeException("Feedback not found!"));
    }

    @Override
    public String Delete(Long id) {
         feedbackRepository.deleteById(id);
         return "Feed back deleted successfully!";
    }
}
