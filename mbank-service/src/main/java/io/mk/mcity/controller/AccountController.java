package io.mk.mcity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("balance/{accNumber}")
	public String getAccountBalance(String accNumber) {
		return "$ 2300";
	}
}
