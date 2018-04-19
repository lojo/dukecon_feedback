package org.dukecon.feedback.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Feedback {
    @NonNull
    private String author;
    @NonNull
    private ConferenceId conferenceId;
    @NonNull
    private TalkId talkId;

    private String comment;
    private Integer rating;
}
