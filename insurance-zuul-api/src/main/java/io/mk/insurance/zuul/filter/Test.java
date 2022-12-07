package io.mk.insurance.zuul.filter;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Test {

	public static void main(String[] args) {
		URI url;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYWEiLCJleHAiOjE2NzA0MDM5MTgsImlhdCI6MTY3MDQwMzYxOH0.Jm_zcOl6-iUYNGGHhUCHzR3dehb1tpC35VPGyugXjOvzuJ9WtUxDN8WP8A8YTcWM2p6jP9Yrng1bBzfcx2Vmnw");
			HttpEntity<String> entity = new HttpEntity<>(headers);

			url = new URI("http://localhost:8564/verifytoken");
			ResponseEntity<String> exchange = new RestTemplate().exchange(url, HttpMethod.GET, entity, String.class);
			System.out.println(exchange.getBody());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
