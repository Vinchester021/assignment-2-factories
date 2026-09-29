package com.example.smartsecurity;

public class WarehouseAlertService implements AlertService {

    @Override
    public String sendAlert(String message) {
        return "Warehouse manager and security team alert: " + message;
    }

    @Override
    public String notifyEmergencyService() {
        return "Warehouse security and emergency services have been notified.";
    }

    @Override
    public String getAlertChannel() {
        return "Warehouse control panel and security radio";
    }
}