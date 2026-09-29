package com.example.smartsecurity;

public class FireEventCreator extends SecurityEventCreator {

    @Override
    public SecurityEvent createEvent() {
        return new FireEvent();
    }

    @Override
    protected String executeResponse(
            SecuritySystem securitySystem
    ) {
        return securitySystem.startEvacuation();
    }
}