package com.example.smartsecurity;

public class OfficeAlertService {

    public String sendAlert(String message) {
        return "Office administrator and security team alert: " + message;
    }

    public String notifyEmergencyService() {
        return "Office security team has been notified.";
    }

    public String getAlertChannel() {
        return "Administrator dashboard and security team";
    }
}