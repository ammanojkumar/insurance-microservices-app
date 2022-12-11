package io.mk.insurance.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "${jwt.base.url}", name = "insurance-jwt-service")
public interface JwtClient {
	@RequestMapping(value = "jwt/verifytoken")
	public String checkTokenValidation(@RequestHeader("authorization") String authorization);
}
