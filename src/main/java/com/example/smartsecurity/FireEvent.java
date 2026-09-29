package com.example.smartsecurity;

public class FireEvent implements SecurityEvent {

    @Override
    public String getType() {
        return "FIRE";
    }

    @Override
    public String getDescription() {
        return "Smoke or fire has been detected.";
    }

    @Override
    public int getPriority() {
        return 3;
    }
}