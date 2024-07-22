package com.shawn.cloud_stream.application.controller;

import com.shawn.cloud_stream.application.dto.TestDto;
import com.shawn.cloud_stream.infrastructure.stream.TestPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/kafka")
@RequiredArgsConstructor
public class testController {
    private final TestPublisher testPublisher;

    @GetMapping
    public TestDto sampleRequest(@RequestParam String name, @RequestParam String surname, @RequestParam String randomMessage){
        var testDto = TestDto.builder()
                .name(name)
                .surname(surname)
                .randomMessage(randomMessage)
                .build();

        testPublisher.publish(testDto);

        return testDto;
    }

}
