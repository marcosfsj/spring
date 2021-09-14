package com.example.demo.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeClock implements Clock {

    @Override
    public Instant now() {
        return LocalDateTime.now().toInstant(ZoneOffset.UTC);
    }

    @Override
    public long currentTimeMillis() {
        return now().toEpochMilli();
    }
}
