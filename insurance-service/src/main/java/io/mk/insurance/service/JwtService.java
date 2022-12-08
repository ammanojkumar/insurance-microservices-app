
package io.mk.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mk.insurance.feign.client.JwtClient;

@Service
public class JwtService {

	@Autowired
	private JwtClient jwtClient;

	public String checkTokenValidation(String authorization) {
		return jwtClient.checkTokenValidation(authorization);
	}

}
