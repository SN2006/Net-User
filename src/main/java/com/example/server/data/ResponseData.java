package com.example.server.data;

public class ResponseData {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[Server]: " + message;
    }
}
