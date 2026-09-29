package com.example.smartsecurity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityEventCreatorTest {

    @Test
    void intrusionCreatorCreatesIntrusionEvent() {
        SecurityEventCreator creator =
                new IntrusionEventCreator();

        SecurityEvent event = creator.createEvent();

        assertInstanceOf(IntrusionEvent.class, event);
        assertEquals("INTRUSION", event.getType());
        assertEquals(3, event.getPriority());
    }

    @Test
    void fireCreatorCreatesFireEvent() {
        SecurityEventCreator creator =
                new FireEventCreator();

        SecurityEvent event = creator.createEvent();

        assertInstanceOf(FireEvent.class, event);
        assertEquals("FIRE", event.getType());
        assertEquals(3, event.getPriority());
    }

    @Test
    void vacationCreatorCreatesVacationEvent() {
        SecurityEventCreator creator =
                new VacationEventCreator();

        SecurityEvent event = creator.createEvent();

        assertInstanceOf(VacationEvent.class, event);
        assertEquals("VACATION", event.getType());
        assertEquals(1, event.getPriority());
    }

    @Test
    void intrusionCreatorProcessesEvent() {
        SecuritySystem system = new SecuritySystem(
                new ApartmentSecurityFactory()
        );

        String result = new IntrusionEventCreator()
                .processEvent(system);

        assertTrue(result.contains("INTRUSION"));
        assertTrue(result.contains("HIGH"));
        assertTrue(result.contains("Threat detected"));
    }

    @Test
    void fireCreatorProcessesEvent() {
        SecuritySystem system = new SecuritySystem(
                new VillaSecurityFactory()
        );

        String result = new FireEventCreator()
                .processEvent(system);

        assertTrue(result.contains("FIRE"));
        assertTrue(result.contains("HIGH"));
        assertTrue(result.contains("evacuation"));
    }

    @Test
    void vacationCreatorProcessesEvent() {
        SecuritySystem system = new SecuritySystem(
                new OfficeSecurityFactory()
        );

        String result = new VacationEventCreator()
                .processEvent(system);

        assertTrue(result.contains("VACATION"));
        assertTrue(result.contains("LOW"));
        assertTrue(result.contains("armed"));
    }

    @Test
    void nullSecuritySystemThrowsException() {
        SecurityEventCreator creator =
                new IntrusionEventCreator();

        assertThrows(
                NullPointerException.class,
                () -> creator.processEvent(null)
        );
    }
}