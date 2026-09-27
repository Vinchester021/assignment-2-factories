package com.example.smartsecurity;

public class OfficeAccessController {

    public String lockAllEntrances() {
        return "Office doors are locked using employee access cards.";
    }

    public String openEmergencyExits() {
        return "Office emergency exits are unlocked for evacuation.";
    }

    public String getAccessMethod() {
        return "Employee cards and electronic door locks";
    }
}