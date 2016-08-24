package com.at.library.service.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.BookDao;
import com.at.library.dto.BookDTO;
import com.at.library.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<BookDTO> findAll() {
		final Iterable<Book> findAll = bookDao.findAll();
		final Iterator<Book> iterator = findAll.iterator();
		final List<BookDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Book b = iterator.next();
			final BookDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	@Override
	public BookDTO transform(Book book) {
		return dozer.map(book, BookDTO.class);
	}

	@Override
	public Book transform(BookDTO book) {
		return dozer.map(book, Book.class);
	}
	
	@Override
	public List<BookDTO> transform(List<Book> book) {	
		final Iterator<Book> iterator = book.iterator();
		final List<BookDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Book b = iterator.next();
			final BookDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	@Override
	public BookDTO create(BookDTO book) {
		Book b = transform(book);
		return transform(bookDao.save(b));
	}

	@Override
	public BookDTO getById(Integer id) {
		Book b = bookDao.findOne(id);
		return transform(b);
	}

	@Override
	public void update(BookDTO book) {
		Book b = transform(book);
		bookDao.save(b);		
	}

	@Override
	public void delete(Integer id) {
		bookDao.delete(id);
	}

	@Override
	public List<BookDTO> getByParams(String name, String isbn, String author) {
		List<BookDTO> b;
		// No se pasa ningun parametro
		if(name == null && isbn == null && author == null){
			return this.findAll();
		}
		// Solo se pasa el autor
		else if(name == null && isbn == null){
			b = transform(bookDao.findByAuthor(author));
		}
		// Solo se pasa el isbn
		else if(name == null && author == null){
			b = transform(bookDao.findByIsbn(isbn));
		}
		// Solo se pasa el nombre
		else if(isbn == null && author == null){
			b = transform(bookDao.findByTitle(name));
		}
		// Se pasa el isbn y el autor
		else if(name == null){
			b = transform(bookDao.findByIsbnAndAuthor(isbn,author));
		}
		// Se pasa el nombre y el autor
		else if(isbn == null){
			b = transform(bookDao.findByTitleAndAuthor(name,author));
		}
		// Se pasa el nombre y el isbn
		else if(author == null){
			b = transform(bookDao.findByTitleAndIsbn(name,isbn));
		}
		// Se le pasa todo
		else{
			 b = transform(bookDao.findByTitleAndIsbnAndAuthor(name,isbn,author));
		}
		
		return b;
	}

}
