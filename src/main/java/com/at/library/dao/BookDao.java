package com.at.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.at.library.dto.BookDTO;
import com.at.library.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

	@Query(value="SELECT new com.at.library.dto.BookDTO(b.id,b.isbn,b.title,b.author) from Book as b where b.id in (select r.rentPK.book.id from Rent as r where r.endDate is null)")
	public List<BookDTO> findUnavailable();
	
	List<Book> findByAuthor(String author);

	List<Book> findByIsbn(String isbn);

	List<Book> findByTitle(String title);

	List<Book> findByIsbnAndAuthor(String isbn, String author);

	List<Book> findByTitleAndAuthor(String name, String author);

	List<Book> findByTitleAndIsbn(String name, String isbn);

	List<Book> findByTitleAndIsbnAndAuthor(String name, String isbn, String author);
	
}
