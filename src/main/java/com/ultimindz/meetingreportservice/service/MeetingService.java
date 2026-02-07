package com.ultimindz.meetingreportservice.service;

import com.ultimindz.meetingreportservice.dto.CreateMeetingRequest;
import com.ultimindz.meetingreportservice.entity.Meeting;
import com.ultimindz.meetingreportservice.exception.NotFoundException;
import com.ultimindz.meetingreportservice.repository.MeetingRepository;
import com.ultimindz.meetingreportservice.repository.spec.MeetingSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository){
        this.meetingRepository = meetingRepository;
    }

    public Meeting create(CreateMeetingRequest request){
        Meeting meeting = new Meeting();
        meeting.setTitle(request.getTitle());
        meeting.setOrganizerEmail(request.getOrganizerEmail());
        meeting.setStartTime(request.getStartTime());
        meeting.setEndTime(request.getEndTime());

        return meetingRepository.save(meeting);
    }

    public Meeting getById(Long id){
        return meetingRepository.findById(id).orElseThrow(() -> new NotFoundException("Meeting not found: " + id));
    }

    public Page<Meeting> search(LocalDateTime from, LocalDateTime to, String organizerEmail, Pageable pageable) {
        Specification<Meeting> spec = Specification
                .where(MeetingSpecifications.startTimeFrom(from))
                .and(MeetingSpecifications.startTimeTo(to))
                .and(MeetingSpecifications.organizerEmailEquals(organizerEmail));

        return meetingRepository.findAll(spec, pageable);
    }
}
