package org.dukecon.feedback.domain.model;

import lombok.Value;

@Value(staticConstructor="of")
public class ConferenceId {
    private String id;
}
