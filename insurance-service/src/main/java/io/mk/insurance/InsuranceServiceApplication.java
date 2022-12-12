package io.mk.insurance;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableEurekaClient
public class InsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceServiceApplication.class, args);
	}

	@Value("${jwt.base.url}")
	private String baseUrl;

	@PostConstruct
	public void printCloudConfigs() {
		System.out.println("baseUrl: " + baseUrl);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate () {
		return new RestTemplate();
	}

}
