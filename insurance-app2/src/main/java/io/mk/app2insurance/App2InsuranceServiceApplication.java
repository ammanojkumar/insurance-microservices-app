package io.mk.app2insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@SpringBootApplication
@EnableEurekaClient
public class App2InsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(App2InsuranceServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate () {
		return new RestTemplate();
	}
}