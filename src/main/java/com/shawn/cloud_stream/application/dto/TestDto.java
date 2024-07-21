package com.shawn.cloud_stream.application.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record TestDto(String name, String surname, String randomMessage) {
}
