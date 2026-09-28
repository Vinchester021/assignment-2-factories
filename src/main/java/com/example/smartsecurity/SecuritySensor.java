package com.example.smartsecurity;

public interface SecuritySensor {

    String startMonitoring();

    boolean detectThreat(String threatType);

    String getSensorType();
}