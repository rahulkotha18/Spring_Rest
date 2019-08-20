package com.luv2code.springdemo.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerErrorResponse {
    private int statuscode;
    private String message;
    private long timestamp;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public CustomerErrorResponse()
    {
    }

    public CustomerErrorResponse(int statuscode, String message, long timestamp) {
        this.statuscode = statuscode;
        this.message = message;
        this.timestamp = timestamp;
    }
}
