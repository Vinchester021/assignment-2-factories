package com.example.smartsecurity;

public class VillaAccessController {

    public String lockAllEntrances() {
        return "Villa gates and doors are locked using biometric access.";
    }

    public String openEmergencyExits() {
        return "Villa gates are opened for emergency evacuation.";
    }

    public String getAccessMethod() {
        return "Biometric gates and smart locks";
    }
}