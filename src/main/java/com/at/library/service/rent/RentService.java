package com.at.library.service.rent;

import java.util.List;

import com.at.library.dto.RentDTO;
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
	 * @return
	 */
	Rent transform(RentDTO Rent);

	RentDTO create(RentDTO rent);

	RentDTO getById(Integer id);

	void update(RentDTO rent);

	void delete(Integer id);

}
