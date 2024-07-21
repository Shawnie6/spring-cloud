package com.shawn.cloud_stream.infrastructure.stream;

import com.shawn.cloud_stream.application.dto.TestDto;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class TestPublisher extends AbstractPublisher<TestDto>{

    public TestPublisher(StreamBridge streamBridge) {
        super(streamBridge, "testEventOutput");
    }
}
