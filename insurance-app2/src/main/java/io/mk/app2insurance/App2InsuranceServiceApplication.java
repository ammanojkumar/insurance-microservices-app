package io.mk.app2insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class App2InsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(App2InsuranceServiceApplication.class, args);
	}

}
