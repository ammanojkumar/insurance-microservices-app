package io.mk.insurance.zuul.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "http://localhost:8040/insurance-jwt-service/", name = "insurance-jwt-service")
public interface JwtClient {
	@RequestMapping(value = "verifytoken")
	public String getResponse(@RequestHeader("authorization") String authorization);
}
