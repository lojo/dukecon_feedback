package org.dukecon.feedback.domain.model;

import lombok.Value;

@Value(staticConstructor="of")
public class TalkId {
    private String id;
}
