package com.example.smartsecurity;

public class VillaSecuritySensor {

    public String startMonitoring() {
        return "Villa perimeter, glass-break and camera sensors are monitoring.";
    }

    public boolean detectThreat(String threatType) {
        return threatType.equalsIgnoreCase("perimeter")
                || threatType.equalsIgnoreCase("intrusion")
                || threatType.equalsIgnoreCase("glass");
    }

    public String getSensorType() {
        return "Perimeter, glass-break and camera sensors";
    }
}