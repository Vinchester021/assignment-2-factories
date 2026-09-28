package com.example.smartsecurity;

public class VillaAccessController implements AccessController {

    @Override
    public String lockAllEntrances() {
        return "Villa gates and doors are locked using biometric access.";
    }

    @Override
    public String openEmergencyExits() {
        return "Villa gates are opened for emergency evacuation.";
    }

    @Override
    public String getAccessMethod() {
        return "Biometric gates and smart locks";
    }
}