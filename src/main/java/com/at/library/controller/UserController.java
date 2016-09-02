package com.at.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.RentDTO;
import com.at.library.dto.UserDTO;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.exception.UserNotFoundException;
import com.at.library.service.user.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(method={RequestMethod.GET})
	public List<UserDTO> getAll() {
		log.debug("Buscando todos los usuarios en el sistema");
		return userService.findAll();
	}
	
	@RequestMapping(method={RequestMethod.POST})
	public UserDTO create(@RequestBody UserDTO user) throws InvalidDataException {
		log.debug(String.format("Vamos a crear el usuario %s", user));
		return userService.create(user);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.GET})
	public UserDTO get(@PathVariable("id") Integer id) throws UserNotFoundException {
		log.debug(String.format("Recuperando usuario con id: %s",id));
		return userService.getByIdDTO(id);
	}

	@RequestMapping(value="/{id}", method={RequestMethod.PUT})
	public void update(@PathVariable("id") Integer id, @RequestBody UserDTO user) throws InvalidDataException,UserNotFoundException {
		log.debug(String.format("Vamos a modificar el usuario %s", user));
		userService.update(user);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.DELETE})
	public void delete(@PathVariable("id") Integer id) throws UserNotFoundException{
		log.debug(String.format("Vamos a modificar el usuario con id %s", id));
		userService.delete(id);
	}
	
	@RequestMapping(value="/search",method={RequestMethod.GET})
	public List<UserDTO> get(@RequestParam(value="dni",required=false) String dni, 
							 @RequestParam(value="name",required=false) String name, 
							 @RequestParam(value="surname1",required=false) String surname1,
							 @RequestParam(value="surname2",required=false) String surname2,
							 @RequestParam(value="address",required=false) String address,
							 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
						 	 @RequestParam(value = "size", required = false, defaultValue = "10") Integer size)
							 throws UserNotFoundException {
		
		log.debug(String.format("Recuperando usuario con dni: %s, nombre: %s, apellido 1: %s, apellido 2: %s, direccion: %s",dni,name,surname1,surname2,address));
		return userService.getByParams(dni,name,surname1,surname2,address, new PageRequest(page,size));
	}
	
	@RequestMapping(value="/{id}/history", method={RequestMethod.GET})
	public List<RentDTO> history(@PathVariable("id") Integer id,
					@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			 		@RequestParam(value = "size", required = false, defaultValue = "10") Integer size) 
					throws UserNotFoundException, RentNotFoundException {
		
		log.debug(String.format("Recuperando alquileres del usuario con id %s", id));
		List<RentDTO> r = userService.getRents(id, new PageRequest(page,size));
		return r;
	}

}
