package com.at.library.service.rent;

import java.util.List;

import com.at.library.dto.RentDTO;
import com.at.library.dto.RentPostDTO;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.BookRentedException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.exception.UserNotFoundException;
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
	 * @throws UserNotFoundException
	 * @throws InvalidDataException 
	 * @throws BookRentedException 
	 * @throws BookNotFoundException 
	 */

	RentDTO create(RentPostDTO rent) throws UserNotFoundException, InvalidDataException, BookRentedException, BookNotFoundException;
	
	/**
	 * Devuelve, si existe, un alquiler cuyo id coincida con el parametro introducido
	 * @param id
	 * @return Rent
	 * @throws RentNotFoundException 
	 */
	Rent getById(Integer id) throws RentNotFoundException;

	
	/**
	 * Devuelve, si existe, un alquilerDTO cuyo id coincida con el parametro introducido
	 * @param id
	 * @return RentDTO
	 * @throws RentNotFoundException 
	 */
	RentDTO getByIdDTO(Integer id) throws RentNotFoundException;
	
	/**
	 * Permite modificar un alquiler concreto
	 * @param rent
	 * @throws InvalidDataException 
	 */
	void update(RentDTO rent) throws InvalidDataException;

	/**
	 * Permite eliminar un alquiler concreto
	 * @param id
	 * @throws RentNotFoundException 
	 */
	void delete(Integer id) throws RentNotFoundException;

	/**
	 * Permite efectuar la devolución en un alquiler concreto cuyo id del libro coincida con el parametro introducido
	 * @param id
	 * @throws BookNotFoundException 
	 */
	void restore(Integer book_id) throws BookNotFoundException;

	/**
	 * Permite devolver todos los alquileres cuyo usuario_id coincida con el introducido 
	 * @param id
	 * @return List<RentDTO>
	 * @throws RentNotFoundException 
	 */
	List<RentDTO> getByUserId(Integer id) throws RentNotFoundException;

	/**
	 * Permite devolver todos los alquileres cuyo libro_id coincida con el introducido 
	 * @param id
	 * @return List<RentDTO>
	 * @throws RentNotFoundException 
	 */
	List<RentDTO> getByBookId(Integer id) throws RentNotFoundException;

	/**
	 * Devuelve todos los alquileres retrasados
	 * @return List<Rent>
	 */
	List<Rent> findDelayed();

}
