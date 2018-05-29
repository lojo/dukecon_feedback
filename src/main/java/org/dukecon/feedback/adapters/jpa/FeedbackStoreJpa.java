package org.dukecon.feedback.adapters.jpa;

import lombok.extern.slf4j.Slf4j;
import org.dukecon.feedback.adapters.jpa.model.FeedbackEntity;
import org.dukecon.feedback.domain.FeedbackStore;
import org.dukecon.feedback.domain.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class FeedbackStoreJpa implements FeedbackStore {
    @Autowired
    private FeedbackRepositoryJpa feedbackRepositoryJpa;

    @Override
    @Transactional
    public void saveOverwriteExisting(Feedback feedback) {
        FeedbackEntity entity
            = FeedbackEntity
                .builder()
                .author(feedback.getAuthor())
                .conference(feedback.getConferenceId().getId())
                .talk(feedback.getTalkId().getId())
                .rating(feedback.getRating())
                .comment(feedback.getComment())
                .build();
        List<FeedbackEntity> existingEntities = feedbackRepositoryJpa.findByAuthorAndConferenceAndTalk(feedback.getAuthor(), feedback.getConferenceId().getId(), feedback.getTalkId().getId());
        if (existingEntities.size() == 1) {
            FeedbackEntity existingEntity = existingEntities.get(0);
            existingEntity.setRating(feedback.getRating());
            existingEntity.setComment(feedback.getComment());
            feedbackRepositoryJpa.save(existingEntity);
        }
        else {
            feedbackRepositoryJpa.deleteByAuthorConferenceAndTalk(feedback.getAuthor(), feedback.getConferenceId().getId(), feedback.getTalkId().getId());
            feedbackRepositoryJpa.save(entity);
        }
        log.info("Saved feedback for conference {} and talk {}", feedback.getConferenceId().getId(), feedback.getTalkId().getId());
    }

}
