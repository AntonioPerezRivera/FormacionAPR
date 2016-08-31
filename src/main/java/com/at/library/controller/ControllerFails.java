package com.at.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.at.library.dto.ApiErrorDTO;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.BookRentedException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.exception.RoomNotFoundException;
import com.at.library.exception.UserNotFoundException;
import com.at.library.exception.ZoneNotFoundException;

@ControllerAdvice(basePackages= {"com.at.library.controller"})
public class ControllerFails {

	@ResponseBody
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO error(InvalidDataException e){
		return new ApiErrorDTO(400,e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorDTO error(BookNotFoundException e){
		return new ApiErrorDTO(404,e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorDTO error(UserNotFoundException e){
		return new ApiErrorDTO(404,e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(BookRentedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ApiErrorDTO error(BookRentedException e){
		return new ApiErrorDTO(500,e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(RentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorDTO error(RentNotFoundException e){
		return new ApiErrorDTO(404,e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(RoomNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorDTO error(RoomNotFoundException e){
		return new ApiErrorDTO(404,e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(ZoneNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorDTO error(ZoneNotFoundException e){
		return new ApiErrorDTO(404,e.getMessage());
	}
	
}
