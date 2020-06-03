package com.khoubyari.example.service;

import org.springframework.context.ApplicationEvent;

public class CityServiceEvent extends ApplicationEvent {

    public CityServiceEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My CityService Event";
    }
}
