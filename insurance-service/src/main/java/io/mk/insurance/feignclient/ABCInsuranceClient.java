package io.mk.insurance.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mk.insurance.model.Insurer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@FeignClient(url = "http://desktop-ms1g9rh:8091/", name = "abc-insurance")
public interface ABCInsuranceClient {

	@RequestMapping("abcinsurance/detail/{brand}/{model}")
	public Insurer getInsuranceDetail(@PathVariable String brand, @PathVariable String model);
}
