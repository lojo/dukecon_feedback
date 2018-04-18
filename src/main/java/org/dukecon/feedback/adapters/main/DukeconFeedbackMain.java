package org.dukecon.feedback.adapters.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.dukecon.feedback")
public class DukeconFeedbackMain {

    public static void main(String[] args) {
        SpringApplication.run(DukeconFeedbackMain.class, args);
    }
}

