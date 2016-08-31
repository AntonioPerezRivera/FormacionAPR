package com.at.library.service.room;

import java.util.List;

import com.at.library.dto.RoomDTO;
import com.at.library.dto.RoomPostDTO;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RoomNotFoundException;
import com.at.library.exception.ZoneNotFoundException;
import com.at.library.model.Room;

public interface RoomService {

	/**
	 * Realiza la busqueda de todas las salas existentes
	 * 
	 * @return listado de salas
	 */
	List<RoomDTO> findAll();

	/**
	 * Transforma una sala en un salaDTO
	 * 
	 * @param room
	 * @return
	 */
	RoomDTO transform(Room room);

	/**
	 * Transforma un salaDTO en una sala
	 * 
	 * @param room
	 * @return
	 */
	Room transform(RoomDTO room);

	/**
	 * Permite devolver una habitacion concreta dado un id
	 * @param id
	 * @return
	 * @throws RoomNotFoundException 
	 */
	RoomDTO getById(Integer id) throws RoomNotFoundException;

	/**
	 * Permite actualizar una habitacion concreta
	 * @param room
	 * @throws InvalidDataException 
	 */
	void update(RoomDTO room) throws InvalidDataException;

	/**
	 * Permite eliminar una habitacion concreta
	 * @param id
	 * @throws RoomNotFoundException 
	 */
	void delete(Integer id) throws RoomNotFoundException;

	/**
	 * Permite devolver una habitacion concreta dependiendo del nombre
	 * @param nameRoom
	 * @return
	 */
	Room getByName(String nameRoom);

	RoomDTO create(RoomPostDTO room) throws RoomNotFoundException, ZoneNotFoundException;

}
