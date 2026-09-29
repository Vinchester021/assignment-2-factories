package com.example.smartsecurity;

public class WarehouseAccessController implements AccessController {

    @Override
    public String lockAllEntrances() {
        return "Warehouse gates and loading docks are locked.";
    }

    @Override
    public String openEmergencyExits() {
        return "Warehouse emergency exits and loading gates are opened.";
    }

    @Override
    public String getAccessMethod() {
        return "RFID employee cards and electronic gate locks";
    }
}