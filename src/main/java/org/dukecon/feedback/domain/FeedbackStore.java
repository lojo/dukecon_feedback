package org.dukecon.feedback.domain;

import org.dukecon.feedback.domain.model.Feedback;

public interface FeedbackStore {
    void saveOverwriteExisting(Feedback feedback);
}
