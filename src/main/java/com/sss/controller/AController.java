package com.sss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.service.AService;

@RestController
@RequestMapping("/a")
public class AController {

	@Value("${server.port}")
	public String port;
	
	@Autowired
	public AService aservice;
	
	
	
	@RequestMapping("/a")
	public String a(String name) {
		System.out.println(name);
		System.out.println(port);
		String aString = aservice.a(name);
		return aString+"----";
	}
	
}
