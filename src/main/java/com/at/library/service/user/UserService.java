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

}
