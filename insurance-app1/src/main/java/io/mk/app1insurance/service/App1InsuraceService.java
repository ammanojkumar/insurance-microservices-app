package io.mk.app1insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mk.app1insurance.exception.ItemNotFoundException;
import io.mk.app1insurance.model.Insurance;
import io.mk.app1insurance.repository.App1Repo;

@Service
public class App1InsuraceService {

	@Autowired
	private App1Repo app1Repo;

	public Insurance getInsurance(String brand, String model) {
		Optional<Insurance> ins = app1Repo.findByBrandAndModel(brand, model);
		if (ins.isPresent()) {
			return ins.get();
		} else {
			throw new ItemNotFoundException();
		}
	}

	public Insurance saveInsurance(Insurance insurance) {
		return app1Repo.save(insurance);
	}

	public Insurance updateInsurance(Insurance insurance) {
		Optional<Insurance> insOp = app1Repo.findById(insurance.getInsuranceId());
		if (insOp.isPresent()) {
			Insurance ins = insOp.get();
			ins.setIdv(insurance.getIdv());
			ins.setBrand(insurance.getBrand());
			ins.setCompanyName(insurance.getCompanyName());
			ins.setInsuranceAmount(insurance.getInsuranceAmount());
			return ins;
		} else {
			throw new ItemNotFoundException();
		}
	}

	public List<Insurance> saveAllInsurance(List<Insurance> insurances) {
		return app1Repo.saveAll(insurances);
	}

}
