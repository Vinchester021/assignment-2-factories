package com.example.smartsecurity;

public class OfficeAccessController implements AccessController {

    @Override
    public String lockAllEntrances() {
        return "Office doors are locked using employee access cards.";
    }

    @Override
    public String openEmergencyExits() {
        return "Office emergency exits are unlocked for evacuation.";
    }

    @Override
    public String getAccessMethod() {
        return "Employee cards and electronic door locks";
    }
}