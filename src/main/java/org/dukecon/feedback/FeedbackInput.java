package org.dukecon.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class FeedbackInput {
    private int rating;
    private String comment;
}