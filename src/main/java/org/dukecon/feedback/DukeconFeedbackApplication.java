package org.dukecon.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DukeconFeedbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DukeconFeedbackApplication.class, args);
    }

    @RequestMapping("rest/feedback")
    @RestController
    private static class FeedbackController {
        @PutMapping("event/{conferenceId}/{eventId}")
        public ResponseEntity sendFeedback(@PathVariable("conferenceId") String conferenceId, @PathVariable("eventId") String eventId, @RequestBody FeedbackInput feedbackInput) {
            System.out.println(String.format("feedback for %s/%s: %s (Authentication: %s)", conferenceId, eventId, feedbackInput, SecurityContextHolder.getContext().getAuthentication()));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @GetMapping("event/{conferenceId}/{eventId}")
        public String existsFeedback(@PathVariable("conferenceId") String conferenceId, @PathVariable("eventId") String eventId) {
            return "Ok (Dummy data)";
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class FeedbackInput {
    private int rating;
    private String comment;
}