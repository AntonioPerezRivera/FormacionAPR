package com.at.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.ZoneDTO;
import com.at.library.dto.ZonePostDTO;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.ZoneNotFoundException;
import com.at.library.service.zone.ZoneService;

@RestController
@RequestMapping(value = "/zone")
public class ZoneController {

	@Autowired
	private ZoneService zoneService;

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(ZoneController.class);
	
	@RequestMapping(method={RequestMethod.GET})
	public List<ZoneDTO> getAll() {
		log.debug("Buscando todos los zonas en el sistema");
		return zoneService.findAll();
	}
	
	@RequestMapping(method={RequestMethod.POST})
	public ZoneDTO create(@RequestBody ZonePostDTO rent) throws BookNotFoundException, ZoneNotFoundException {
		log.debug(String.format("Vamos a crear la zona %s", rent));
		return zoneService.create(rent);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.GET})
	public ZoneDTO get(@PathVariable("id") Integer id){
		log.debug(String.format("Recuperando zona con id: %s",id));
		return zoneService.getById(id);
	}

	@RequestMapping(value="/{id}", method={RequestMethod.PUT})
	public void update(@PathVariable("id") Integer id, @RequestBody ZoneDTO zone){
		log.debug(String.format("Vamos a modificar la zona %s", zone));
		zoneService.update(zone);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.DELETE})
	public void delete(@PathVariable("id") Integer id){
		log.debug(String.format("Vamos a modificar la zona con id %s", id));
		zoneService.delete(id);
	}

}
