package io.mk.insurance.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InsuranceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceApiGatewayApplication.class, args);
	}

}
