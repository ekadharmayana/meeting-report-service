package com.ultimindz.meetingreportservice.controller;

import com.ultimindz.meetingreportservice.dto.CreateMeetingRequest;
import com.ultimindz.meetingreportservice.dto.MeetingResponse;
import com.ultimindz.meetingreportservice.entity.Meeting;
import com.ultimindz.meetingreportservice.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService){
        this.meetingService = meetingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MeetingResponse create(@Valid @RequestBody CreateMeetingRequest request){
        Meeting meeting = meetingService.create(request);
        return MeetingResponse.from(meeting.getId(), meeting.getTitle(), meeting.getOrganizerEmail(), meeting.getStartTime(), meeting.getEndTime());
    }

    @GetMapping("/{id}")
    public MeetingResponse getById(@PathVariable Long id){
        Meeting meeting = meetingService.getById(id);
        return MeetingResponse.from(meeting.getId(), meeting.getTitle(), meeting.getOrganizerEmail(), meeting.getStartTime(), meeting.getEndTime());
    }
}
