package com.example.smartsecurity;

import java.util.Objects;

public abstract class SecurityEventCreator {

    public abstract SecurityEvent createEvent();

    protected abstract String executeResponse(
            SecuritySystem securitySystem
    );

    public final String processEvent(SecuritySystem securitySystem) {

        Objects.requireNonNull(
                securitySystem,
                "Security system cannot be null"
        );

        SecurityEvent event = Objects.requireNonNull(
                createEvent(),
                "Created security event cannot be null"
        );

        String priorityName = switch (event.getPriority()) {
            case 3 -> "HIGH";
            case 2 -> "MEDIUM";
            default -> "LOW";
        };

        return "Event type: " + event.getType() + "\n"
                + "Description: " + event.getDescription() + "\n"
                + "Priority: " + priorityName + "\n"
                + "Response:\n"
                + executeResponse(securitySystem);
    }
}