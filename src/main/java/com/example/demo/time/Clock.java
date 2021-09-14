package com.example.demo.time;

import java.time.Instant;

public interface Clock {
    Instant now();
    long currentTimeMillis();
}
