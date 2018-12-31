package com.example.sslserver;

import com.example.sslserver.client.SSLData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@EnableFeignClients
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
@RestController
class SecuredServerController{

	@Autowired
	SSLData sslData;

	@GetMapping("/client_secured")
	public Object secured(){
		System.out.println("Inside client");

		return sslData.secured1();
	}
}

