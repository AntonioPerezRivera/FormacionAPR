package com.at.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.RentDTO;
import com.at.library.service.rent.RentService;

@RestController
@RequestMapping(value = "/rent")
public class RentController {

	@Autowired
	private RentService rentService;

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(RentController.class);
	
	@RequestMapping(method={RequestMethod.GET})
	public List<RentDTO> getAll() {
		log.debug("Buscando todos los alquileres en el sistema");
		return rentService.findAll();
	}
	
	@RequestMapping(method={RequestMethod.POST})
	public RentDTO create(@RequestBody RentDTO rent){
		log.debug(String.format("Vamos a crear el alquiler %s", rent));
		return rentService.create(rent);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.GET})
	public RentDTO get(@PathVariable("id") Integer id){
		log.debug(String.format("Recuperando alquiler con id: %s",id));
		return rentService.getById(id);
	}

	@RequestMapping(value="/{id}", method={RequestMethod.PUT})
	public void update(@PathVariable("id") Integer id, @RequestBody RentDTO rent){
		log.debug(String.format("Vamos a modificar el alquiler %s", rent));
		rentService.update(rent);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.PUT})
	public void delete(@PathVariable("id") Integer id){
		log.debug(String.format("Vamos a modificar el alquiler con id %s", id));
		rentService.delete(id);
	}

}
