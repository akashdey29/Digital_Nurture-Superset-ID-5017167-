package com.example.bookstoreapi.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public CustomMetrics customMetrics(MeterRegistry registry) {
        return new CustomMetrics(registry);
    }

    public static class CustomMetrics {
        public CustomMetrics(MeterRegistry registry) {
            registry.counter("custom_metric", "type", "example");
        }
    }
}
