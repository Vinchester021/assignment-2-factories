package com.example.smartsecurity;

public class ApartmentAccessController implements AccessController {

    @Override
    public String lockAllEntrances() {
        return "Apartment doors are locked using PIN access.";
    }

    @Override
    public String openEmergencyExits() {
        return "Apartment entrance doors are opened for evacuation.";
    }

    @Override
    public String getAccessMethod() {
        return "PIN and intercom";
    }
}