package com.at.library.service.room;

import java.util.List;

import com.at.library.dto.RoomDTO;
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

	RoomDTO create(RoomDTO room);

	RoomDTO getById(Integer id);

	void update(RoomDTO room);

	void delete(Integer id);

	Room getByName(String nameRoom);

}
