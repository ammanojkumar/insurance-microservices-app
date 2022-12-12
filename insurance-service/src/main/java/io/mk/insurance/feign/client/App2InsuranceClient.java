package io.mk.insurance.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mk.insurance.model.Insurer;

@FeignClient(url = "${insurance.base.url}", name = "app2-insurance")
public interface App2InsuranceClient {

	@RequestMapping(value = "app2insurance/{brand}/{model}")
	public Insurer getResponse(@PathVariable String brand, @PathVariable String model,
			@RequestHeader("authorization") String authorization);
}
