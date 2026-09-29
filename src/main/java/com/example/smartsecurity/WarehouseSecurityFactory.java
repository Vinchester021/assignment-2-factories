package com.example.smartsecurity;

public class WarehouseSecurityFactory implements SecuritySystemFactory {

    @Override
    public AccessController createAccessController() {
        return new WarehouseAccessController();
    }

    @Override
    public SecuritySensor createSecuritySensor() {
        return new WarehouseSecuritySensor();
    }

    @Override
    public AlertService createAlertService() {
        return new WarehouseAlertService();
    }
}