package org.dukecon.feedback.adapters.jpa;

import org.dukecon.feedback.adapters.jpa.model.FeedbackEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepositoryJpa extends CrudRepository<FeedbackEntity, Long> {

    @Modifying
    @Query("DELETE FROM feedback f WHERE f.author = :author AND f.conference = :conference AND f.talk = :talk")
    void deleteByAuthorConferenceAndTalk(@Param("author") String author, @Param("conference") String conference, @Param("talk") String talk);

    List<FeedbackEntity> findByAuthorAndConferenceAndTalk(String author, String conference, String talk);
}
