package com.example.smartsecurity;

public class VacationEvent implements SecurityEvent {

    @Override
    public String getType() {
        return "VACATION";
    }

    @Override
    public String getDescription() {
        return "The building is switching to vacation security mode.";
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
