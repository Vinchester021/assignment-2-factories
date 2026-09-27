package com.example.smartsecurity;

public class ApartmentAccessController {

    public String lockAllEntrances() {
        return "Apartment doors are locked using PIN access.";
    }

    public String openEmergencyExits() {
        return "Apartment entrance doors are opened for evacuation.";
    }

    public String getAccessMethod() {
        return "PIN and intercom";
    }
}