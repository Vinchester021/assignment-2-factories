package com.example.smartsecurity;

public class OfficeSecuritySensor {

    public String startMonitoring() {
        return "Office access, smoke and occupancy sensors are monitoring.";
    }

    public boolean detectThreat(String threatType) {
        return threatType.equalsIgnoreCase("unauthorized access")
                || threatType.equalsIgnoreCase("smoke")
                || threatType.equalsIgnoreCase("intrusion");
    }

    public String getSensorType() {
        return "Access, smoke and occupancy sensors";
    }
}