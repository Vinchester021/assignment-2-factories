package com.example.smartsecurity;

public class IntrusionEventCreator extends SecurityEventCreator {

    @Override
    public SecurityEvent createEvent() {
        return new IntrusionEvent();
    }

    @Override
    protected String executeResponse(
            SecuritySystem securitySystem
    ) {
        return securitySystem.handleIntrusion("intrusion");
    }
}