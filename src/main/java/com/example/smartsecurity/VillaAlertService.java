package com.example.smartsecurity;

public class VillaAlertService {

    public String sendAlert(String message) {
        return "Villa owner and security company alert: " + message;
    }

    public String notifyEmergencyService() {
        return "Private security company has been notified.";
    }

    public String getAlertChannel() {
        return "Owner application and private security company";
    }
}