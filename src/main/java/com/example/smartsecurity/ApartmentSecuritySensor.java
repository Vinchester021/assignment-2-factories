package com.example.smartsecurity;

public class ApartmentSecuritySensor {

    public String startMonitoring() {
        return "Apartment smoke and motion sensors are monitoring.";
    }

    public boolean detectThreat(String threatType) {
        return threatType.equalsIgnoreCase("smoke")
                || threatType.equalsIgnoreCase("motion");
    }

    public String getSensorType() {
        return "Smoke and motion sensors";
    }
}