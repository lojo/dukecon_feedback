package org.dukecon.feedback.adapters.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackInput {
    private int rating;
    private String comment;
}