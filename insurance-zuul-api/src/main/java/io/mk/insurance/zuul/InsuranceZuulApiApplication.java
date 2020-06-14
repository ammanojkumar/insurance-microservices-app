package io.mk.insurance.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class InsuranceZuulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceZuulApiApplication.class, args);
	}

}
