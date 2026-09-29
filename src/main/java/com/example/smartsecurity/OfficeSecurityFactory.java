package com.example.smartsecurity;

public class OfficeSecurityFactory implements SecuritySystemFactory {

    @Override
    public AccessController createAccessController() {
        return new OfficeAccessController();
    }

    @Override
    public SecuritySensor createSecuritySensor() {
        return new OfficeSecuritySensor();
    }

    @Override
    public AlertService createAlertService() {
        return new OfficeAlertService();
    }
}