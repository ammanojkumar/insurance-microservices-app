package io.mk.app1insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.app1insurance.model.Insurance;
import io.mk.app1insurance.service.App1InsuraceService;

@RestController
@RequestMapping("app1insurance")
public class App1InsuraceController {

	static Map<String, Insurance> insMap = new HashMap<>();

	@Autowired
	private App1InsuraceService app1Service;

	@GetMapping("/{brand}/{model}")
	public ResponseEntity<Insurance> getInsurance(@PathVariable String brand, @PathVariable String model) {
		return new ResponseEntity<>(app1Service.getInsurance(brand, model), HttpStatus.OK);
	}

	@PostMapping("save")
	public ResponseEntity<Insurance> saveInsurance(@RequestBody Insurance insurance) {
		return new ResponseEntity<>(app1Service.saveInsurance(insurance), HttpStatus.OK);
	}

	@PostMapping("saveAll")
	public ResponseEntity<List<Insurance>> saveAllInsurance(@RequestBody List<Insurance> insurances) {
		return new ResponseEntity<>(app1Service.saveAllInsurance(insurances), HttpStatus.OK);
	}
}
