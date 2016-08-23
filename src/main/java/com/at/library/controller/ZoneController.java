package com.at.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.ZoneDTO;
import com.at.library.service.zone.ZoneService;

@RestController
public class ZoneController {

	@Autowired
	private ZoneService zoneService;

	@RequestMapping(value = "/zone", method = { RequestMethod.GET })
	public List<ZoneDTO> getAll() {
		return zoneService.findAll();
	}

}
