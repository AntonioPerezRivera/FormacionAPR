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

	/**
	 * Devuelve una zona, si existe, con el id especificado
	 * @param id
	 * @return ZoneDTO
	 * @throws ZoneNotFoundException
	 */
	ZoneDTO getById(Integer id) throws ZoneNotFoundException;

	
	/**
	 * Permite actualizar una zona concreta
	 * @param zone
	 * @throws InvalidDataException
	 */
	void update(ZoneDTO zone) throws InvalidDataException;

	/**
	 * Permite eliminar por completo una zona
	 * @param id
	 * @throws ZoneNotFoundException
	 */
	void delete(Integer id) throws ZoneNotFoundException;

	/**
	 * Permite crear una nueva zona
	 * @param zone
	 * @return
	 * @throws BookNotFoundException
	 * @throws InvalidDataException
	 */
	ZoneDTO create(ZonePostDTO zone) throws BookNotFoundException, InvalidDataException;

	/**
	 * Devuelve, si existe, una zona con el nombre especificado
	 * @param name
	 * @return Zone
	 * @throws ZoneNotFoundException
	 */
	Zone getByName(String name) throws ZoneNotFoundException;

}

