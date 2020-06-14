
package io.mk.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.mk.insurance.model.InsuranceDetail;
import io.mk.insurance.model.Insurer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@Service
public class InsuranceService {

	@Autowired
	private RestTemplate restTemplate;

	public InsuranceDetail getInsuranceDetail(String brand, String model) {
		InsuranceDetail insuranceDetail = new InsuranceDetail();

		// Calling microservice 1
		String abcInsUrl = "http://desktop-ms1g9rh:8091/abcinsurance/detail/" + brand + "/" + model;
		Insurer insResp1 = restTemplate.getForObject(abcInsUrl, Insurer.class);
		insuranceDetail.getInsurers().add(insResp1);

		// Calling microservice 2
		String xyzInsUrl = "http://desktop-ms1g9rh:8092/xyzinsurance/detail/" + brand + "/" + model;
		Insurer insResp2 = restTemplate.getForObject(xyzInsUrl, Insurer.class);
		insuranceDetail.getInsurers().add(insResp2);

		return insuranceDetail;
	}
}
