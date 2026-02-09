package com.ultimindz.meetingreportservice.service;

import com.ultimindz.meetingreportservice.dto.CreateMeetingRequest;
import com.ultimindz.meetingreportservice.entity.Meeting;
import com.ultimindz.meetingreportservice.exception.NotFoundException;
import com.ultimindz.meetingreportservice.repository.MeetingRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MeetingServiceTest {

    @Test
    void create_shouldPresistMeeting() {
        MeetingRepository repo = mock(MeetingRepository.class);
        MeetingService service = new MeetingService(repo);

        CreateMeetingRequest req = new CreateMeetingRequest();
        req.setTitle("Daily");
        req.setOrganizerEmail("lead@example.com");
        req.setStartTime(LocalDateTime.of(2026, 2, 5, 9, 0));
        req.setEndTime(LocalDateTime.of(2026, 2, 5, 9, 15));

        Meeting saved = new Meeting();
        saved.setId(1L);
        saved.setTitle(req.getTitle());
        saved.setOrganizerEmail(req.getOrganizerEmail());
        saved.setStartTime(req.getStartTime());
        saved.setEndTime(req.getEndTime());

        when(repo.save(any(Meeting.class))).thenReturn(saved);

        Meeting result = service.create(req);

        assertNotNull(result.getId());
        assertEquals("Daily", result.getTitle());
        verify(repo, times(1)).save(any(Meeting.class));

    }

    @Test
    void getById_shouldThrowNotFound_whenMissing() {
        MeetingRepository repo = mock(MeetingRepository.class);
        MeetingService service = new MeetingService(repo);

        when(repo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getById(99L));
    }
}
