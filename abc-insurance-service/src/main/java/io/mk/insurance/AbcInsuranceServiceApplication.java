package io.mk.insurance;

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
public class AbcInsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcInsuranceServiceApplication.class, args);
	}

}
