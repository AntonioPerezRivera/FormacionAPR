package com.at.library.service.book;

import java.util.List;

import com.at.library.dto.BookDTO;
import com.at.library.enums.StatusEnum;
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
	 */
	BookDTO create(BookDTO book);
	
	/**
	 * Devuelve, si existe, un libro cuyo id corresponda con el introducido
	 * @param id
	 * @return BookDTO
	 */
	Book getById(Integer id);

	/**
	 * Devuelve, si existe, un libro cuyo id corresponda con el introducido
	 * @param id
	 * @return BookDTO
	 */
	BookDTO getByIdDTO(Integer id);
	
	/**
	 * Devuelve, si existe, los libros cuyo nombre, isbn o autor correspondan con los introducidos
	 * @param name
	 * @param isbn
	 * @param author
	 * @return List<BookDTO>
	 */
	List<BookDTO> getByParams(String name, String isbn, String author);
	
	/**
	 * Permite la modificacion de un libro concreto
	 * @param book
	 */
	void update(BookDTO book);

	/**
	 * Elimina un libro cuyo id corresponda con el introducido
	 * @param id
	 */
	void delete(Integer id);


	/**
	 * Modifica el estado de un libro concreto
	 */
	void modifyStatus(Book b, StatusEnum s);
}
