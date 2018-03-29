package com.sss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AService {

	@Autowired
	RestTemplate restTemplate;
	
	
	
	@HystrixCommand(fallbackMethod = "aErr")
	public String a(String name) {
		String url = "http://CLIENT-TESTA/a/a?name="+name;
		System.out.println("service a method a");
		return restTemplate.getForObject(url, String.class);
	}
	
	
	public String aErr(String name) {
		return "a"+name+"  err";
	}
	
}
