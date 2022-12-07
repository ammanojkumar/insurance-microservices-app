package io.mk.app2insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
}