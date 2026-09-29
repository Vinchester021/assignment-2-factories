package com.example.smartsecurity;

public class IntrusionEvent implements SecurityEvent {

    @Override
    public String getType() {
        return "INTRUSION";
    }

    @Override
    public String getDescription() {
        return "Unauthorized intrusion has been detected.";
    }

    @Override
    public int getPriority() {
        return 3;
    }
}