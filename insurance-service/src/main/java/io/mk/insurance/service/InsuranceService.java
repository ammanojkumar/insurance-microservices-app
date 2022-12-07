
package io.mk.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.mk.insurance.feign.client.InsuranceClient;
import io.mk.insurance.model.Insurer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@Service
public class InsuranceService {

	@Autowired
	private InsuranceClient insuranceClient;

	@Value("${app1.insurance.name}")
	String app1Service;

	@Value("${app2.insurance.name}")
	String app2Service;

	@HystrixCommand(fallbackMethod = "getApp1InsuranceFb")
	public Insurer getApp1Insurance(String brand, String model, String authorization) {
		return insuranceClient.getResponse(app1Service, brand, model, authorization);
	}

	@HystrixCommand(fallbackMethod = "getApp2InsuranceFb")
	public Insurer getApp2Insurance(String brand, String model, String authorization) {
		return insuranceClient.getResponse(app2Service, brand, model, authorization);
	}

	public Insurer getApp1InsuranceFb(String brand, String model, String authorization) {
		System.out.println("App1 service down: " + brand);
		return new Insurer();
	}

	public Insurer getApp2InsuranceFb(String brand, String model, String authorization) {
		System.out.println("App2 service down: " + brand);
		return new Insurer();
	}

}
