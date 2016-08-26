package com.at.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.library.dto.BookDTO;
import com.at.library.service.book.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(method={RequestMethod.GET})
	public List<BookDTO> getAll() {
		log.debug("Buscando todos los libros en el sistema");
		return bookService.findAll();
	}
	
	@RequestMapping(method={RequestMethod.POST})
	public BookDTO create(@RequestBody BookDTO book){
		log.debug(String.format("Vamos a crear el libro %s", book));
		return bookService.create(book);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.GET})
	public BookDTO get(@PathVariable("id") Integer id){
		log.debug(String.format("Recuperando libro con id: %s",id));
		return bookService.getByIdDTO(id);
	}
	
	@RequestMapping(value="/buscar",method={RequestMethod.GET})
	public List<BookDTO> get(@RequestParam(value="name",required=false) String name, @RequestParam(value="isbn",required=false) String isbn, @RequestParam(value="author",required=false) String author){
		log.debug(String.format("Recuperando libro con nombre: %s, isbn: %s y autor: %s",name,isbn,author));
		return bookService.getByParams(name,isbn,author);
	}

	@RequestMapping(value="/{id}", method={RequestMethod.PUT})
	public void update(@PathVariable("id") Integer id, @RequestBody BookDTO book){
		log.debug(String.format("Vamos a modificar el libro %s", book));
		bookService.update(book);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.DELETE})
	public void delete(@PathVariable("id") Integer id){
		log.debug(String.format("Vamos a modificar el libro con id %s", id));
		bookService.delete(id);
	}

}
