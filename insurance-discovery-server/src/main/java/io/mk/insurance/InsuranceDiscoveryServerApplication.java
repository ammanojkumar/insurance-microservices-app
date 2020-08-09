package io.mk.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@SpringBootApplication
@EnableEurekaServer
public class InsuranceDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceDiscoveryServerApplication.class, args);
	}

}
