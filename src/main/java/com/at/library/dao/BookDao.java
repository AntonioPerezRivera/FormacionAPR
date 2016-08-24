package com.at.library.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.at.library.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

	List<Book> findAllBooks();

	List<Book> findByAuthor(String author);

	List<Book> findByIsbn(String isbn);

	List<Book> findByTitle(String title);

	List<Book> findByIsbnAndAuthor(String isbn, String author);

	List<Book> findByTitleAndAuthor(String name, String author);

	List<Book> findByTitleAndIsbn(String name, String isbn);

	List<Book> findByTitleAndIsbnAndAuthor(String name, String isbn, String author);
	
}
