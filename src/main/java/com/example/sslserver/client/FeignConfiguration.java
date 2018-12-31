package com.example.sslserver.client;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.Logger;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Feign.Builder feignBuilder(){
        Client trustSSLSockets = new    Client.Default(TrustingSSLSocketFactory.get(), null);
        return Feign.builder().client(trustSSLSockets);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }

}