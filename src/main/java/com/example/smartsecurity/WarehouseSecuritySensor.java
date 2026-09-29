package com.example.smartsecurity;

public class WarehouseSecuritySensor implements SecuritySensor {

    @Override
    public String startMonitoring() {
        return "Warehouse motion, smoke and loading-zone sensors are monitoring.";
    }

    @Override
    public boolean detectThreat(String threatType) {
        return threatType.equalsIgnoreCase("intrusion")
                || threatType.equalsIgnoreCase("smoke")
                || threatType.equalsIgnoreCase("unauthorized loading");
    }

    @Override
    public String getSensorType() {
        return "Motion, smoke and loading-zone sensors";
    }
}