package com.ultimindz.meetingreportservice.service;

import com.ultimindz.meetingreportservice.dto.CreateMeetingRequest;
import com.ultimindz.meetingreportservice.entity.Meeting;
import com.ultimindz.meetingreportservice.exception.NotFoundException;
import com.ultimindz.meetingreportservice.repository.MeetingRepository;
import org.springframework.stereotype.Service;

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
}
