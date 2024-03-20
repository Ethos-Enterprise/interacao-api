package com.ethos.interacaoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InteracaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteracaoApiApplication.class, args);
	}

}
