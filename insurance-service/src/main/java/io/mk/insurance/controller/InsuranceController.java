package io.mk.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.insurance.model.InsuranceDetail;
import io.mk.insurance.service.InsuranceService;

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

	@RequestMapping("detail/{brand}/{model}")
	public InsuranceDetail getInsuranceDetail(@PathVariable String brand, @PathVariable String model) {
		return insuranceService.getInsuranceDetail(brand, model);
	}
}
