package com.at.library.service.user;

import java.util.List;

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
	UserDTO getById(Integer id);

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

}
