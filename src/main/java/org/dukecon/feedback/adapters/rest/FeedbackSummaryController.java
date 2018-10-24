package org.dukecon.feedback.adapters.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rest/feedbacksummary")
@RestController
@RequiredArgsConstructor
@PreAuthorize("isFullyAuthenticated() && hasRole('admin')")
public class FeedbackSummaryController {

    @GetMapping("event/{conferenceId}")
    public String exportFeedbackSummary(@PathVariable String conferenceId) {
        System.out.println(String.format("feedback for %s/%s (Authentication: %s)", conferenceId, SecurityContextHolder.getContext().getAuthentication()));
        return "Ok (Dummy data)";
    }

    @GetMapping("event/{conferenceId}/{eventId}")
    public String exportFeedbackSummary(@PathVariable String conferenceId, @PathVariable String eventId) {
        System.out.println(String.format("feedback for %s/%s (Authentication: %s)", conferenceId, eventId, SecurityContextHolder.getContext().getAuthentication()));
        return "Ok (Dummy data)";
    }
}

