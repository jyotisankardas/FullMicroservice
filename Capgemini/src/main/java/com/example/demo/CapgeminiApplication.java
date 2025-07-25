package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.demo.feignclint")
public class CapgeminiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapgeminiApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getinstances() {
		 RestTemplate temp=new RestTemplate();
		 return temp;
	}

}
