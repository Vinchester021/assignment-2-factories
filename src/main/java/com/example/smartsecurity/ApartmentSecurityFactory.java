package com.example.smartsecurity;

public class ApartmentSecurityFactory implements SecuritySystemFactory {

    @Override
    public AccessController createAccessController() {
        return new ApartmentAccessController();
    }

    @Override
    public SecuritySensor createSecuritySensor() {
        return new ApartmentSecuritySensor();
    }

    @Override
    public AlertService createAlertService() {
        return new ApartmentAlertService();
    }
}