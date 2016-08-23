package com.at.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.EmployeeDTO;
import com.at.library.service.employee.EmployeeService;

@RestController
public class RentController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/book", method = { RequestMethod.GET })
	public List<EmployeeDTO> getAll() {
		return employeeService.findAll();
	}

}
