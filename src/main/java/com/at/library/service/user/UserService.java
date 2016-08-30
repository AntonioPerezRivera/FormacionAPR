package com.at.library.service.user;

import java.util.List;

import com.at.library.dto.RentDTO;
import com.at.library.dto.UserDTO;
import com.at.library.enums.UserEnum;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.exception.UserNotFoundException;
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
	 * @throws InvalidDataException 
	 * @throws UserNotFoundException 
	 */
	UserDTO create(UserDTO user) throws InvalidDataException, InvalidDataException;

	/**
	 * Devuelve, si existe, un usuario cuyo id concida con el introducido
	 * @param id
	 * @return UserDTO
	 * @throws UserNotFoundException 
	 */
	User getById(Integer id) throws UserNotFoundException;

	/**
	 * Modifica un usuario concreto
	 * @param user
	 * @throws InvalidDataException 
	 */
	void update(UserDTO user) throws InvalidDataException;

	/**
	 * Permite eliminar un usuario si existe el usuario con el id introducido
	 * @param id
	 * @throws UserNotFoundException 
	 */
	void delete(Integer id) throws UserNotFoundException;

	/**
	 * Permite recuperar el usuarioDTO del usuario con el identificador introducido
	 * @param id
	 * @return UserDTO
	 * @throws UserNotFoundException 
	 */
	
	UserDTO getByIdDTO(Integer id) throws UserNotFoundException;

	/**
	 * Permite recuperar el historial de alquileres dado un usuario concreto
	 * @param id
	 * @return List<RentDTO>
	 * @throws UserNotFoundException 
	 * @throws RentNotFoundException 
	 */
	List<RentDTO> getRents(Integer id) throws UserNotFoundException, RentNotFoundException;

	/**
	 * Permite la busqueda de un usuario concreto
	 * @param dni
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @param address
	 * @return List<UserDTO>
	 * @throws UserNotFoundException 
	 */
	List<UserDTO> getByParams(String dni, String name, String surname1, String surname2, String address) throws UserNotFoundException;

	/**
	 * Permite penalizar a los usuarios que se hayan retrasado en la devolucion de los libros
	 * @throws UserNotFoundException
	 * @throws RentNotFoundException 
	 */
	void punish() throws UserNotFoundException, RentNotFoundException;

	/**
	 * Permite levantar el castigo a los usuarios
	 */
	void forgive();

	/**
	 * Modifica el estado de un usuario concreto
	 * @throws BookNotFoundException 
	 */
	void modifyStatus(User u, UserEnum s) throws UserNotFoundException;
	
}
