package com.example.smartsecurity;

public class ApartmentAlertService implements AlertService {

    @Override
    public String sendAlert(String message) {
        return "Resident mobile notification: " + message;
    }

    @Override
    public String notifyEmergencyService() {
        return "Apartment emergency service has been notified.";
    }

    @Override
    public String getAlertChannel() {
        return "Resident mobile application";
    }
}