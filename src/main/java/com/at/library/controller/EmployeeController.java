package com.at.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.EmployeeDTO;
import com.at.library.service.employee.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(method={RequestMethod.GET})
	public List<EmployeeDTO> getAll() {
		log.debug("Buscando todos los empleados en el sistema");
		return employeeService.findAll();
	}
	
	@RequestMapping(method={RequestMethod.POST})
	public EmployeeDTO create(@RequestBody EmployeeDTO employee){
		log.debug(String.format("Vamos a crear el empleado %s", employee));
		return employeeService.create(employee);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.GET})
	public EmployeeDTO get(@PathVariable("id") Integer id){
		log.debug(String.format("Recuperando empleado con id: %s",id));
		return employeeService.getByIdDTO(id);
	}

	@RequestMapping(value="/{id}", method={RequestMethod.PUT})
	public void update(@PathVariable("id") Integer id, @RequestBody EmployeeDTO employee){
		log.debug(String.format("Vamos a modificar el empleado %s", employee));
		employeeService.update(employee);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.DELETE})
	public void delete(@PathVariable("id") Integer id){
		log.debug(String.format("Vamos a modificar el empleado con id %s", id));
		employeeService.delete(id);
	}

}
