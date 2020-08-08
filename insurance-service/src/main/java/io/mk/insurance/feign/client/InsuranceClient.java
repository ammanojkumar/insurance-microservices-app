package io.mk.insurance.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mk.insurance.model.Insurer;

@FeignClient(url = "${insurance.base.url}", name = "insurance-service")
public interface InsuranceClient {

	@RequestMapping(value = "{appName}/detail/{brand}/{model}")
	public Insurer getResponse(@PathVariable String appName, @PathVariable String brand, @PathVariable String model,
			@RequestHeader("header2") String header1);
}
