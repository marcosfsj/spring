package com.example.demo.time;

import com.example.demo.Factory;

import java.util.ServiceLoader;

public class ClockFactory implements Factory<Clock> {

    private static final Clock CLOCK = ServiceLoader.load(Clock.class).findFirst().orElseGet(LocalDateTimeClock::new);

    @Override
    public Clock getInstance() {
        return CLOCK;
    }
}
