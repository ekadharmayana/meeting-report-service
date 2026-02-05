package com.ultimindz.meetingreportservice.repository;

import com.ultimindz.meetingreportservice.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
