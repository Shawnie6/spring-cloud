package com.shawn.cloud_stream.infrastructure.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractPublisher<EVENT> implements EventPublisher<EVENT> {
    private final StreamBridge streamBridge;
    private final String bindingName;

    public void publish(EVENT event){
        log.info("publishing message {} to binding {}", event, bindingName);
        streamBridge.send(bindingName, event);
    }
}
