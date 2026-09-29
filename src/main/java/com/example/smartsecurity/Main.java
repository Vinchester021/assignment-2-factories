package com.example.smartsecurity;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        String family = args.length > 0
                ? args[0]
                : "apartment";

        SecuritySystemFactory factory = selectFactory(family);
        SecuritySystem securitySystem = new SecuritySystem(factory);

        SecurityEventCreator vacationCreator =
                new VacationEventCreator();

        SecurityEventCreator intrusionCreator =
                new IntrusionEventCreator();

        SecurityEventCreator fireCreator =
                new FireEventCreator();

        System.out.println("=== SMART SECURITY SYSTEM ===");
        System.out.println("Selected family: " + family);

        System.out.println("\n--- Operation 1: Vacation mode ---");
        System.out.println(
                vacationCreator.processEvent(securitySystem)
        );

        System.out.println("\n--- Operation 2: Handle intrusion ---");
        System.out.println(
                intrusionCreator.processEvent(securitySystem)
        );

        System.out.println("\n--- Operation 3: Handle fire ---");
        System.out.println(
                fireCreator.processEvent(securitySystem)
        );
    }

    public static SecuritySystemFactory selectFactory(String family) {

        if (family == null || family.isBlank()) {
            throw new IllegalArgumentException(
                    "Security family cannot be empty"
            );
        }

        return switch (family.trim().toLowerCase(Locale.ROOT)) {
            case "apartment" -> new ApartmentSecurityFactory();
            case "villa" -> new VillaSecurityFactory();
            case "office" -> new OfficeSecurityFactory();
            case "warehouse" -> new WarehouseSecurityFactory();
            default -> throw new IllegalArgumentException(
                    "Unknown security family: " + family
            );
        };
    }
}