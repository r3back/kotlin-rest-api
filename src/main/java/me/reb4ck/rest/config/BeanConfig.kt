package me.reb4ck.rest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class BeanConfig {
    @Bean
    open fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}