package io.mk.insurance.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.mk.insurance.zuul.filter.InsuranceZuulFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableEurekaClient
public class InsuranceZuulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceZuulApiApplication.class, args);
	}

	@Bean
	public InsuranceZuulFilter simpleFilter() {
		return new InsuranceZuulFilter();
	}

}
