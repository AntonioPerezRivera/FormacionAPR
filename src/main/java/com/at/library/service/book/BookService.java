package com.at.library.service.book;

import java.util.List;

import com.at.library.dto.BookDTO;
import com.at.library.model.Book;

public interface BookService {

	/**
	 * Realiza la busqueda de todos los libros existentes
	 * 
	 * @return listado de libros
	 */
	List<BookDTO> findAll();

	/**
	 * Transfrma un libro en un libroDTO
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
	
	// Crea un libro
	BookDTO create(BookDTO book);
	
	// Busca un libro por id
	BookDTO getById(Integer id);

	// Busca un libro por nombre
	List<BookDTO> getByParams(String name, String isbn, String author);
	
	// Modifica un libro
	void update(BookDTO book);

	// Borra un libro
	void delete(Integer id);


}
