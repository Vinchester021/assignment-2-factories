package com.example.smartsecurity;

public class VillaAlertService implements AlertService {

    @Override
    public String sendAlert(String message) {
        return "Villa owner and security company alert: " + message;
    }

    @Override
    public String notifyEmergencyService() {
        return "Private security company has been notified.";
    }

    @Override
    public String getAlertChannel() {
        return "Owner application and private security company";
    }
}