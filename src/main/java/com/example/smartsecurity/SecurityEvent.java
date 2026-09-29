package com.example.smartsecurity;

public interface SecurityEvent {

    String getType();

    String getDescription();

    int getPriority();
}