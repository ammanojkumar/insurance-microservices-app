package io.mk.insurance.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import io.mk.insurance.zuul.filter.InsuranceZuulFilter;

@SpringBootApplication
@EnableZuulProxy
public class InsuranceZuulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceZuulApiApplication.class, args);
	}
	
	  @Bean
	  public InsuranceZuulFilter simpleFilter() {
	    return new InsuranceZuulFilter();
	  }

}
