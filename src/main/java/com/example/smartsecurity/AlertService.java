package com.example.smartsecurity;

public interface AlertService {

    String sendAlert(String message);

    String notifyEmergencyService();

    String getAlertChannel();
}