package io.mk.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.mk.atm.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("balance/{accNumber}")
	public String getAccountBalance(@PathVariable String accNumber) {
		return "$ 2300";
	}
}
