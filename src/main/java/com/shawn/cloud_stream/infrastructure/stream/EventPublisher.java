package com.shawn.cloud_stream.infrastructure.stream;

public interface EventPublisher<EVENT> {
    void publish(EVENT event);
}
