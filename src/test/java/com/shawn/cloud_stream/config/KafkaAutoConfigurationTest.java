package com.shawn.cloud_stream.config;

import org.assertj.core.api.AbstractStringAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class KafkaAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner =
            new ApplicationContextRunner()
                    .withConfiguration(AutoConfigurations.of(
                            KafkaAutoConfiguration.class,
                            KafkaCustomAutoConfiguration.class
                    ));

    //move to a helper class
    public static void publishEvent(ApplicationContext context, ConfigurableEnvironment environment){
        var event = new ApplicationEnvironmentPreparedEvent(null, new SpringApplication(), null, environment);
        context.publishEvent(event);
    }

    //move to a helper class
    public static void assertPropertyContains(Environment environment, String propertyName, String value){
        assertThatProperty(environment, propertyName).contains(value);
    }

    private static AbstractStringAssert<?> assertThatProperty(Environment environment, String propertyName){
        return assertThat(environment.getProperty(propertyName));
    }


    @Test
    void shouldRegisterCustomKafkaTemplateBean() {
        contextRunner
                .run(context -> assertThat(context.getBean(KafkaTemplate.class)).isNotNull());
    }

    @Test
    void should_configure_default_properties(){
        this.contextRunner.run(
                context -> {
                    var environment = context.getEnvironment();
                    publishEvent(context, environment);
                    assertPropertyContains(environment,
                            "management.endpoint.health.group.liveness.include",
                            "livenessState, binders");
                }
        );
    }

}
