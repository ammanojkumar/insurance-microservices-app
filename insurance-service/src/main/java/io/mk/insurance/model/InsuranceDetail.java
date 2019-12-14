package io.mk.insurance.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
public class InsuranceDetail {

	private List<Insurer> insurers;

	public List<Insurer> getInsurers() {
		if (insurers == null) {
			insurers = new ArrayList<>();
		}
		return insurers;
	}

	public void setInsurers(List<Insurer> insurers) {
		this.insurers = insurers;
	}

}
