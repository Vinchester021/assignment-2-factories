package com.example.smartsecurity;

public class ApartmentAlertService {

    public String sendAlert(String message) {
        return "Resident mobile notification: " + message;
    }

    public String notifyEmergencyService() {
        return "Apartment emergency service has been notified.";
    }

    public String getAlertChannel() {
        return "Resident mobile application";
    }
}