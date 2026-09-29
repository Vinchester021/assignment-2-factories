package com.example.smartsecurity;

import java.util.Objects;

public class SecuritySystem {

    private final AccessController accessController;
    private final SecuritySensor securitySensor;
    private final AlertService alertService;

    public SecuritySystem(SecuritySystemFactory factory) {
        Objects.requireNonNull(factory, "Security factory cannot be null");

        this.accessController = Objects.requireNonNull(
                factory.createAccessController(),
                "Access controller cannot be null"
        );

        this.securitySensor = Objects.requireNonNull(
                factory.createSecuritySensor(),
                "Security sensor cannot be null"
        );

        this.alertService = Objects.requireNonNull(
                factory.createAlertService(),
                "Alert service cannot be null"
        );
    }

    public String armSystem() {
        return accessController.lockAllEntrances() + "\n"
                + securitySensor.startMonitoring() + "\n"
                + alertService.sendAlert("Security system is armed.");
    }

    public String handleIntrusion(String threatType) {
        if (!securitySensor.detectThreat(threatType)) {
            return "No threat detected: " + threatType;
        }

        return "Threat detected by security sensors.\n"
                + accessController.lockAllEntrances() + "\n"
                + alertService.sendAlert("Possible intrusion detected.") + "\n"
                + alertService.notifyEmergencyService();
    }

    public String startEvacuation() {
        return securitySensor.startMonitoring() + "\n"
                + accessController.openEmergencyExits() + "\n"
                + alertService.sendAlert("Evacuation has started.");
    }
}