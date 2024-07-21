package com.shawn.cloud_stream.application.stream;

import com.shawn.cloud_stream.application.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class testConsumer implements Consumer<TestDto> {
    @Override
    public void accept(TestDto testDto) {
        log.debug("Wow we got a message {}", testDto);
    }
}
