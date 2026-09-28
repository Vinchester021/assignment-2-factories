package com.example.smartsecurity;

public class VillaSecuritySensor implements SecuritySensor {

    @Override
    public String startMonitoring() {
        return "Villa perimeter, glass-break and camera sensors are monitoring.";
    }

    @Override
    public boolean detectThreat(String threatType) {
        return threatType.equalsIgnoreCase("perimeter")
                || threatType.equalsIgnoreCase("intrusion")
                || threatType.equalsIgnoreCase("glass");
    }

    @Override
    public String getSensorType() {
        return "Perimeter, glass-break and camera sensors";
    }
}