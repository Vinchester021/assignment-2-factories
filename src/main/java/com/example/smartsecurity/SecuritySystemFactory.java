package com.example.smartsecurity;

public interface SecuritySystemFactory {

    AccessController createAccessController();

    SecuritySensor createSecuritySensor();

    AlertService createAlertService();
}