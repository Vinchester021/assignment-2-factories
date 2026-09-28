package com.example.smartsecurity;

public class OfficeAlertService implements AlertService {

    @Override
    public String sendAlert(String message) {
        return "Office administrator and security team alert: " + message;
    }

    @Override
    public String notifyEmergencyService() {
        return "Office security team has been notified.";
    }

    @Override
    public String getAlertChannel() {
        return "Administrator dashboard and security team";
    }
}