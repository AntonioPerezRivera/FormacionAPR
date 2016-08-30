package com.at.library.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.service.bookcustom.BookCustomService;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {

	@Autowired
	private BookCustomService bookCustomService;

	@RequestMapping(method={RequestMethod.GET})
	public void getAllJson() {
		String url = "http://192.168.11.57:8080/rent";
		bookCustomService.findAll(url);
	}
}
	