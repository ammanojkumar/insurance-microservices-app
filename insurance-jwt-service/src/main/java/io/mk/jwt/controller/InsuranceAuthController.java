package io.mk.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mk.jwt.config.AuthTokenUtil;
import io.mk.jwt.entity.InsuranceAuthRequest;
import io.mk.jwt.service.InsuranceUserDetailsService;

@RestController
@CrossOrigin
@RequestMapping("jwt")
public class InsuranceAuthController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private AuthTokenUtil authTokenUtil;

	@Autowired
	private InsuranceUserDetailsService userDetailsService;

	@GetMapping("verifytoken")
	public String verifytoken() {
		return "valid";
	}
	
	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public String createAuthenticationToken(@RequestBody InsuranceAuthRequest authRequest) throws Exception {

		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		return authTokenUtil.generateToken(userDetails);
	}
}
