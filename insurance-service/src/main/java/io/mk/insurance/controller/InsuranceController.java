package io.mk.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.insurance.model.InsuranceDetail;
import io.mk.insurance.model.Insurer;
import io.mk.insurance.service.InsuranceService;
import io.mk.insurance.service.JwtService;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@RestController
@RequestMapping(value = "insurances")
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;

	@Autowired
	private JwtService jwtService;

	@RequestMapping("/{brand}/{model}")
	public InsuranceDetail getInsuranceDetail(@PathVariable String brand, @PathVariable String model,
			@RequestHeader("authorization") String authorization) {

		String resp = jwtService.checkTokenValidation(authorization);
		System.out.println("resp " + resp);
		if (!resp.equals("valid")) {
			throw new RuntimeException("Invalid token");
		}
		InsuranceDetail insuranceDetail = new InsuranceDetail();

		Insurer app1Insurance = insuranceService.getApp1Insurance(brand, model, authorization);
		insuranceDetail.getInsurers().add(app1Insurance);

		Insurer app2Insurance = insuranceService.getApp2Insurance(brand, model, authorization);
		insuranceDetail.getInsurers().add(app2Insurance);

		return insuranceDetail;
	}
}
