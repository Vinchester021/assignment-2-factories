package com.example.smartsecurity;

public class OfficeSecuritySensor implements SecuritySensor {

    @Override
    public String startMonitoring() {
        return "Office access, smoke and occupancy sensors are monitoring.";
    }

    @Override
    public boolean detectThreat(String threatType) {
        return threatType.equalsIgnoreCase("unauthorized access")
                || threatType.equalsIgnoreCase("smoke")
                || threatType.equalsIgnoreCase("intrusion");
    }

    @Override
    public String getSensorType() {
        return "Access, smoke and occupancy sensors";
    }
}