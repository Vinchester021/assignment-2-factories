package com.example.smartsecurity;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        String family = args.length > 0
                ? args[0]
                : "apartment";

        SecuritySystemFactory factory = selectFactory(family);
        SecuritySystem securitySystem = new SecuritySystem(factory);

        System.out.println("=== SMART SECURITY SYSTEM ===");
        System.out.println("Selected family: " + family);

        System.out.println("\n--- Operation 1: Arm system ---");
        System.out.println(securitySystem.armSystem());

        System.out.println("\n--- Operation 2: Handle intrusion ---");
        System.out.println(securitySystem.handleIntrusion("intrusion"));

        System.out.println("\n--- Operation 3: Start evacuation ---");
        System.out.println(securitySystem.startEvacuation());
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
            default -> throw new IllegalArgumentException(
                    "Unknown security family: " + family
            );
        };
    }
}