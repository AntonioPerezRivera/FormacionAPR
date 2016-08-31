package com.at.library.service.zone;

import java.util.List;

import com.at.library.dto.ZoneDTO;
import com.at.library.dto.ZonePostDTO;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.ZoneNotFoundException;
import com.at.library.model.Zone;

public interface ZoneService {

	/**
	 * Realiza la busqueda de todas las zonas existentes
	 * 
	 * @return listado de zonas
	 */
	List<ZoneDTO> findAll();

	/**
	 * Transfrma una zona en un zonaDTO
	 * 
	 * @param zone
	 * @return
	 */
	ZoneDTO transform(Zone zone);

	/**
	 * Transforma un zoneDTO en una zone
	 * 
	 * @param zone
	 * @return
	 */
	Zone transform(ZoneDTO zone);

	ZoneDTO getById(Integer id) throws ZoneNotFoundException;

	void update(ZoneDTO zone) throws InvalidDataException;

	void delete(Integer id) throws ZoneNotFoundException;

	ZoneDTO create(ZonePostDTO zone) throws BookNotFoundException, InvalidDataException;

	Zone getByName(String name) throws ZoneNotFoundException;

}

