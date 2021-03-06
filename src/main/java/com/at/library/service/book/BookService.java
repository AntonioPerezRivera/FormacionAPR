package com.at.library.service.book;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.at.library.dto.BookDTO;
import com.at.library.dto.HistoryRentedDTO;
import com.at.library.enums.StatusEnum;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.model.Book;

public interface BookService {

	/**
	 * Realiza la busqueda de todos los libros existentes
	 * 
	 * @return listado de libros
	 */
	List<BookDTO> findAll();

	/**
	 * Transforma un libro en un libroDTO
	 * 
	 * @param book
	 * @return
	 */
	BookDTO transform(Book book);

	/**
	 * Transforma un libroDTO en un libro
	 * 
	 * @param book
	 * @return
	 */
	Book transform(BookDTO book);

	/**
	 * Transforma una lista de libros en una lista de librosDTO
	 * @param List<Book>
	 * @return List<BookDTO>
	 */
	List<BookDTO> transform(List<Book> book);
	
	/**
	 * Crea un libroDTO
	 * @param BookDTO
	 * @return BookDTO
	 * @throws InvalidDataException 
	 */
	BookDTO create(BookDTO book) throws InvalidDataException;
	
	/**
	 * Devuelve, si existe, un libro cuyo id corresponda con el introducido
	 * @param id
	 * @return BookDTO
	 * @throws BookNotFoundException 
	 */
	Book getById(Integer id) throws BookNotFoundException;

	/**
	 * Devuelve, si existe, un libro cuyo id corresponda con el introducido
	 * @param id
	 * @return BookDTO
	 * @throws BookNotFoundException 
	 */
	BookDTO getByIdDTO(Integer id) throws BookNotFoundException;
	
	/**
	 * Devuelve, si existe, los libros cuyo nombre, isbn o autor correspondan con los introducidos
	 * @param name
	 * @param isbn
	 * @param author
	 * @return List<BookDTO>
	 * @throws BookNotFoundException 
	 */
	List<BookDTO> getByParams(String name, String isbn, String author, Pageable pageable) throws BookNotFoundException;
	
	/**
	 * Permite la modificacion de un libro concreto
	 * @param book
	 * @throws InvalidDataException 
	 */
	void update(BookDTO book) throws InvalidDataException;

	/**
	 * Elimina un libro cuyo id corresponda con el introducido
	 * @param id
	 * @throws BookNotFoundException 
	 */
	void delete(Integer id) throws BookNotFoundException;


	/**
	 * Modifica el estado de un libro concreto
	 * @throws BookNotFoundException 
	 */
	void modifyStatus(Book b, StatusEnum s) throws BookNotFoundException;
	
	/**
	 * Comprueba si el estado de un libro se encuentra en disponible
	 * @param b
	 * @return
	 */
	boolean checkStatus(Book b);

	/**
	 * Devuelve una lista con el historial de alquileres del libro con el id introducido
	 * @param id
	 * @return List<RentDTO>
	 * @throws BookNotFoundException 
	 * @throws RentNotFoundException 
	 */
	List<HistoryRentedDTO> getRents(Integer id, Pageable pageable) throws BookNotFoundException, RentNotFoundException;
}
