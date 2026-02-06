package com.ultimindz.meetingreportservice.api;

import java.time.OffsetDateTime;

public class ApiError {
    private OffsetDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public static ApiError of(int status, String error, String message, String path){
        ApiError api = new ApiError();
        api.timestamp = OffsetDateTime.now();
        api.status = status;
        api.error = error;
        api.message = message;
        api.path = path;

        return api;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
