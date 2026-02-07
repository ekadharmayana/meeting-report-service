package com.ultimindz.meetingreportservice.repository.spec;

import com.ultimindz.meetingreportservice.entity.Meeting;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class MeetingSpecifications {

    public static Specification<Meeting> startTimeFrom(LocalDateTime from) {
        return (root, query, cb) ->
                from == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("startTime"), from);
    }

    public static Specification<Meeting> startTimeTo(LocalDateTime to) {
        return (root, query, cb) ->
                to == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get("startTime"), to);
    }

    public static Specification<Meeting> organizerEmailEquals(String organizerEmail) {
        return (root, query, cb) -> {
            if (organizerEmail == null || organizerEmail.isBlank()) return cb.conjunction();
            return cb.equal(cb.lower(root.get("organizerEmail")), organizerEmail.toLowerCase());
        };
    }
}
