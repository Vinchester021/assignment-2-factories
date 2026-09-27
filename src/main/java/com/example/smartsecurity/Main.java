package com.example.smartsecurity;

public class Main {

    public static void main(String[] args) {

        String family;

        if (args.length > 0) {
            family = args[0];
        } else {
            family = "apartment";
        }

        System.out.println("=== SMART SECURITY SYSTEM ===");
        System.out.println("Selected family: " + family);
        System.out.println();

        if (family.equalsIgnoreCase("apartment")) {

            ApartmentAccessController access =
                    new ApartmentAccessController();

            ApartmentSecuritySensor sensor =
                    new ApartmentSecuritySensor();

            ApartmentAlertService alert =
                    new ApartmentAlertService();

            System.out.println("--- Operation 1: Arm system ---");
            System.out.println(access.lockAllEntrances());
            System.out.println(sensor.startMonitoring());
            System.out.println(alert.sendAlert("Security system is armed."));

            System.out.println("\n--- Operation 2: Handle intrusion ---");

            if (sensor.detectThreat("motion")) {
                System.out.println("Threat detected by apartment sensors.");
                System.out.println(access.lockAllEntrances());
                System.out.println(alert.sendAlert("Possible intrusion detected."));
                System.out.println(alert.notifyEmergencyService());
            }

            System.out.println("\n--- Operation 3: Start evacuation ---");
            System.out.println(sensor.startMonitoring());
            System.out.println(access.openEmergencyExits());
            System.out.println(alert.sendAlert("Evacuation has started."));

        } else if (family.equalsIgnoreCase("villa")) {

            VillaAccessController access =
                    new VillaAccessController();

            VillaSecuritySensor sensor =
                    new VillaSecuritySensor();

            VillaAlertService alert =
                    new VillaAlertService();

            System.out.println("--- Operation 1: Arm system ---");
            System.out.println(access.lockAllEntrances());
            System.out.println(sensor.startMonitoring());
            System.out.println(alert.sendAlert("Security system is armed."));

            System.out.println("\n--- Operation 2: Handle intrusion ---");

            if (sensor.detectThreat("perimeter")) {
                System.out.println("Threat detected by villa sensors.");
                System.out.println(access.lockAllEntrances());
                System.out.println(alert.sendAlert("Perimeter intrusion detected."));
                System.out.println(alert.notifyEmergencyService());
            }

            System.out.println("\n--- Operation 3: Start evacuation ---");
            System.out.println(sensor.startMonitoring());
            System.out.println(access.openEmergencyExits());
            System.out.println(alert.sendAlert("Evacuation has started."));

        } else if (family.equalsIgnoreCase("office")) {

            OfficeAccessController access =
                    new OfficeAccessController();

            OfficeSecuritySensor sensor =
                    new OfficeSecuritySensor();

            OfficeAlertService alert =
                    new OfficeAlertService();

            System.out.println("--- Operation 1: Arm system ---");
            System.out.println(access.lockAllEntrances());
            System.out.println(sensor.startMonitoring());
            System.out.println(alert.sendAlert("Security system is armed."));

            System.out.println("\n--- Operation 2: Handle intrusion ---");

            if (sensor.detectThreat("unauthorized access")) {
                System.out.println("Threat detected by office sensors.");
                System.out.println(access.lockAllEntrances());
                System.out.println(alert.sendAlert("Unauthorized access detected."));
                System.out.println(alert.notifyEmergencyService());
            }

            System.out.println("\n--- Operation 3: Start evacuation ---");
            System.out.println(sensor.startMonitoring());
            System.out.println(access.openEmergencyExits());
            System.out.println(alert.sendAlert("Evacuation has started."));

        } else {
            System.out.println("Unknown product family: " + family);
        }
    }
}