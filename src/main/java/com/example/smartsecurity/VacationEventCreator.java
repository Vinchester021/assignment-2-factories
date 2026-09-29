package com.example.smartsecurity;

public class VacationEventCreator extends SecurityEventCreator {

    @Override
    public SecurityEvent createEvent() {
        return new VacationEvent();
    }

    @Override
    protected String executeResponse(
            SecuritySystem securitySystem
    ) {
        return securitySystem.armSystem();
    }
}