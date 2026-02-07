package com.ultimindz.meetingreportservice.controller;

import com.ultimindz.meetingreportservice.dto.CreateMeetingRequest;
import com.ultimindz.meetingreportservice.dto.MeetingResponse;
import com.ultimindz.meetingreportservice.entity.Meeting;
import com.ultimindz.meetingreportservice.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @GetMapping
    public Page<MeetingResponse> list(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime from,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime to,

            @RequestParam(required = false)
            String organizerEmail,

            @PageableDefault(size = 10, sort = "startTime")
            Pageable pageable
    ) {
        return meetingService.search(from, to, organizerEmail, pageable)
                .map(m -> MeetingResponse.from(
                        m.getId(),
                        m.getTitle(),
                        m.getOrganizerEmail(),
                        m.getStartTime(),
                        m.getEndTime()
                ));
    }
}
