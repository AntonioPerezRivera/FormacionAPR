package com.at.library.service.rent;

import java.util.List;

import com.at.library.dto.RentDTO;
import com.at.library.dto.RentPostDTO;
import com.at.library.model.Rent;

public interface RentService {

	/**
	 * Realiza la busqueda de todos los alquileres existentes
	 * 
	 * @return listado de alquileres
	 */
	List<RentDTO> findAll();

	/**
	 * Transfrma un alquiler en un alquilerDTO
	 * 
	 * @param rent
	 * @return
	 */
	RentDTO transform(Rent Rent);

	/**
	 * Transforma un alquilerDTO en un alquiler
	 * 
	 * @param rent
	 * @return Rent
	 */
	Rent transform(RentDTO Rent);

	/**
	 * Permite crear un nuevo alquiler
	 * @param rent
	 * @return RentDTO
	 */

	RentDTO create(RentPostDTO rent);
	
	/**
	 * Devuelve, si existe, un alquiler cuyo id coincida con el parametro introducido
	 * @param id
	 * @return Rent
	 */
	Rent getById(Integer id);

	
	/**
	 * Devuelve, si existe, un alquilerDTO cuyo id coincida con el parametro introducido
	 * @param id
	 * @return RentDTO
	 */
	RentDTO getByIdDTO(Integer id);
	
	/**
	 * Permite modificar un alquiler concreto
	 * @param rent
	 */
	void update(RentDTO rent);

	/**
	 * Permite eliminar un alquiler concreto
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * Permite efectuar la devolución en un alquiler concreto cuyo id coincida con el parametro introducido
	 * @param id
	 */
	//void restore(Integer id);


}
