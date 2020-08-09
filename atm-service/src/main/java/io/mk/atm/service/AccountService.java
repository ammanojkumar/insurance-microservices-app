package io.mk.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mk.atm.feign.client.AccFeignClient;

@Service
public class AccountService {

//	@Autowired
	private AccFeignClient accFeignClient;

	public String getAccountBalance(String accNumber) {
		return "$ 2300";
	}
}
