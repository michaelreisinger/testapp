package com.bactwo.authserver.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * this bean creates a RestTemplate for synchronous Microservice communication
     * WARNING: RestTemplate will be deprecated in a future release of Spring Boot
     * WebClient is the successor having the ability to handle both blocking (synchronous
     * and non-blocking (asynchronous) API calls.
     * We  consider RestTemplate still fine for the test character of this application
     * @return Singleton instance of RestTemplate
     */
    @Bean
    public RestTemplate getRestTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }


}
