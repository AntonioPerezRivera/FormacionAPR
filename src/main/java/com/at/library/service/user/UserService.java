package com.at.library.service.user;

import java.util.List;

import com.at.library.dto.RentDTO;
import com.at.library.dto.UserDTO;
import com.at.library.model.User;

public interface UserService {

	/**
	 * Realiza la busqueda de todos los usuarios existentes
	 * 
	 * @return listado de usuarios
	 */
	List<UserDTO> findAll();

	/**
	 * Transfrma un usuario en un usuarioDTO
	 * 
	 * @param user
	 * @return
	 */
	UserDTO transform(User user);

	/**
	 * Transforma un usuarioDTO en un usuario
	 * 
	 * @param user
	 * @return
	 */
	User transform(UserDTO user);

	/**
	 * Permite transformar una lista de usuarios en una lista de usuariosDTO
	 * @param user
	 * @return List<UserDTO>
	 */
	List<UserDTO> transform(List<User> user);
	
	/**
	 * Crea un usuario
	 * @param user
	 * @return UserDTO
	 */
	UserDTO create(UserDTO user);

	/**
	 * Devuelve, si existe, un usuario cuyo id concida con el introducido
	 * @param id
	 * @return UserDTO
	 */
	User getById(Integer id);

	/**
	 * Modifica un usuario concreto
	 * @param user
	 */
	void update(UserDTO user);

	/**
	 * Permite eliminar un usuario si existe el usuario con el id introducido
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * Permite recuperar el usuarioDTO del usuario con el identificador introducido
	 * @param id
	 * @return UserDTO
	 */
	
	UserDTO getByIdDTO(Integer id);

	/**
	 * Permite recuperar el historial de alquileres dado un usuario concreto
	 * @param id
	 * @return List<RentDTO>
	 */
	List<RentDTO> getRents(Integer id);

	/**
	 * Permite la busqueda de un usuario concreto
	 * @param dni
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @param address
	 * @return List<UserDTO>
	 */
	List<UserDTO> getByParams(String dni, String name, String surname1, String surname2, String address);


}
