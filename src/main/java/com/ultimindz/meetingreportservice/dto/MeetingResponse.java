package com.ultimindz.meetingreportservice.dto;

import java.time.LocalDateTime;

public class MeetingResponse {

    private Long id;
    private String tittle;
    private String organizerEmail;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static MeetingResponse from(Long id, String title, String organizerEmail, LocalDateTime startTime, LocalDateTime endTime){
        MeetingResponse response = new MeetingResponse();
        response.id = id;
        response.tittle = title;
        response.organizerEmail = organizerEmail;
        response.startTime = startTime;
        response.endTime = endTime;
        return response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
