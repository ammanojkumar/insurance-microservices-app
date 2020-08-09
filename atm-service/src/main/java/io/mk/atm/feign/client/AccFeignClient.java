package io.mk.atm.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(url = "${insurance.base.url}", name = "insurance-service")
public interface AccFeignClient {

//	@RequestMapping(value = "{appName}/detail/{brand}/{model}")
//	public String getResponse(@PathVariable String appName, @PathVariable String brand, @PathVariable String model,
//			@RequestHeader("header2") String header1);
}
