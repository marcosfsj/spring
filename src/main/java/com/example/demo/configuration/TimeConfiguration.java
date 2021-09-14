package com.example.demo.configuration;

import com.example.demo.time.Clock;
import com.example.demo.time.ClockFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeConfiguration {

    @Bean
    public Clock clock() {
        return new ClockFactory().getInstance();
    }

}
