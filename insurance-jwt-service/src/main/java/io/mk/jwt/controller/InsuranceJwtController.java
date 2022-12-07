package io.mk.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsuranceJwtController {

	@RequestMapping("verifytoken")
	public String verifytoken() {
		return "valid";
	}
}
