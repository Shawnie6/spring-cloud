package com.shawn.cloud_stream.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@AutoConfiguration
@PropertySource(value = "classpath:kafka-custom-properties.yml", factory = YamlPropertySourceFactory.class)
public class KafkaCustomAutoConfiguration {
}
