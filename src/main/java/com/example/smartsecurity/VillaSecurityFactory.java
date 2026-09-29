package com.example.smartsecurity;

public class VillaSecurityFactory implements SecuritySystemFactory {

    @Override
    public AccessController createAccessController() {
        return new VillaAccessController();
    }

    @Override
    public SecuritySensor createSecuritySensor() {
        return new VillaSecuritySensor();
    }

    @Override
    public AlertService createAlertService() {
        return new VillaAlertService();
    }
}