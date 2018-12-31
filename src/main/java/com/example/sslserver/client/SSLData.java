package com.example.sslserver.client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="SSLData"/*, configuration = FeignConfiguration.class*/, url = "https://localhost:8021")
public interface SSLData {
    @GetMapping("/secured")
    public Object secured1();
}
