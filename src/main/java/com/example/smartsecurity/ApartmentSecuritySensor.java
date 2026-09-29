package com.example.smartsecurity;

public class ApartmentSecuritySensor implements SecuritySensor {

    @Override
    public String startMonitoring() {
        return "Apartment smoke and motion sensors are monitoring.";
    }

    @Override
    public boolean detectThreat(String threatType) {
        return threatType.equalsIgnoreCase("smoke")
                || threatType.equalsIgnoreCase("motion")
                || threatType.equalsIgnoreCase("intrusion");
    }

    @Override
    public String getSensorType() {
        return "Smoke and motion sensors";
    }
}