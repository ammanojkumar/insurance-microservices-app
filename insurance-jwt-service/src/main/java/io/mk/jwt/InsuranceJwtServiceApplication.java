package io.mk.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InsuranceJwtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceJwtServiceApplication.class, args);
	}

}
