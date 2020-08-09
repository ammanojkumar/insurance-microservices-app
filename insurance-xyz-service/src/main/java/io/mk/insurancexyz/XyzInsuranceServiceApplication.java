package io.mk.insurancexyz;

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
public class XyzInsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzInsuranceServiceApplication.class, args);
	}
}