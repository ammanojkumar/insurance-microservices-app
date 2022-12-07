package io.mk.app2insurance.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.app2insurance.model.Insurer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@RestController
@RequestMapping("app2insurance")
public class App2InsuraceController {

	static Map<String, Insurer> insMap = new HashMap<>();

	@RequestMapping("/{brand}/{model}")
	public Insurer getDetail(@PathVariable String brand, @PathVariable String model) {
		if (brand == null || model == null) {
			return null;
		}
		if (model.equals("A1")) {
			throw new RuntimeException("itttt");
		}
		String key = brand.toLowerCase() + model.toLowerCase();
		if (!insMap.containsKey(key)) {
			Insurer ins = new Insurer();
			ins.setCompanyName("APP1");
			ins.setBrand(brand);
			ins.setModel(model);
			Random ran = new Random();
			int amt = ran.nextInt(12000);
			amt = amt < 4000 ? 8000 - amt : amt;
			ins.setInsuranceAmount(amt);
			ins.setIdv(amt * 12);
			insMap.put(key, ins);
		}
		return insMap.get(brand.toLowerCase() + model.toLowerCase());
	}
}
