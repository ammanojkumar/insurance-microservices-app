
package io.mk.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.mk.insurance.feignclient.ABCInsuranceClient;
import io.mk.insurance.feignclient.XYZInsuranceClient;
import io.mk.insurance.model.Insurer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@Service
public class InsuranceService {

	@Autowired
	private ABCInsuranceClient abcInsuranceClient;

	@Autowired
	private XYZInsuranceClient xyzInsuranceClient;

	@HystrixCommand(fallbackMethod = "getInsuranceDetailFallback", commandKey = "getABCInsuranceDetailFromService")
	public Insurer getABCInsuranceDetail(String brand, String model) {
		return abcInsuranceClient.getInsuranceDetail(brand, model);
	}

	@HystrixCommand(fallbackMethod = "getInsuranceDetailFallback", commandKey = "getXYZInsuranceDetailFromService")
	public Insurer getXYZInsuranceDetail(String brand, String model) {
		return xyzInsuranceClient.getInsuranceDetail(brand, model);
	}

	// Histrix fallback method, if any exception arrives
	public Insurer getInsuranceDetailFallback(String brand, String model) {
		return null;
	}
}
