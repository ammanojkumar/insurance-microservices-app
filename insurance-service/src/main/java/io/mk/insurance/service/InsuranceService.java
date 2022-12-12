
package io.mk.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.mk.insurance.feign.client.App1InsuranceClient;
import io.mk.insurance.feign.client.App2InsuranceClient;
import io.mk.insurance.model.Insurer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@Service
public class InsuranceService {

	@Autowired
	private App1InsuranceClient app1InsuranceClient;

	@Autowired
	private App2InsuranceClient app2InsuranceClient;

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getApp1InsuranceFb")
	public Insurer getApp1Insurance(String brand, String model, String authorization) {
		try {
			return app1InsuranceClient.getResponse(brand, model, authorization);
//			return restTemplate.getForObject("http://APP1-INSURANCE/app1insurance/BMW/A8", Insurer.class);
		} catch (Exception e) {
			System.out.println("eeerr");
			e.printStackTrace();
			throw e;
		}
	}

	@HystrixCommand(fallbackMethod = "getApp2InsuranceFb")
	public Insurer getApp2Insurance(String brand, String model, String authorization) {
		return app2InsuranceClient.getResponse(brand, model, authorization);
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
