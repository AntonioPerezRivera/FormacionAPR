package com.at.library.service.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.at.library.dao.BookDao;
import com.at.library.dto.BookDTO;
import com.at.library.dto.HistoryRentedDTO;
import com.at.library.dto.RentDTO;
import com.at.library.enums.StatusEnum;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.model.Book;
import com.at.library.service.rent.RentService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	private RentService rentService;

	private static RestTemplate restTemplate = new RestTemplate();
	private static final String GBOOKS_URL = "https://www.googleapis.com/books/v1/volumes?startIndex=0&maxResults=1&q=";
	
	@Override
	@Transactional(readOnly = true)
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
	public BookDTO create(BookDTO book) throws InvalidDataException {
		if(book == null){
			throw new InvalidDataException();
		}
		else{
			Book b = transform(book);
			b.setStartDate(new Date());
			b.setStatus(StatusEnum.OK);
			return transform(bookDao.save(b));
		}
	}

	@Override
	public Book getById(Integer id) throws BookNotFoundException {
		Book b = bookDao.findOne(id);
		if(b == null){
			throw new BookNotFoundException();
		}
		else {
			return b;
		}
	}
	
	@Override
	public BookDTO getByIdDTO(Integer id) throws BookNotFoundException {
		Book b = bookDao.findOne(id);
		if(b == null){
			throw new BookNotFoundException();
		}
		else {
			BookDTO bDTO = transform(b);
			getGoogleApiInfo(bDTO);
			return bDTO;
		}
	}
	
	public void getGoogleApiInfo(BookDTO bDTO){

		ObjectNode objectNode = restTemplate.getForObject(GBOOKS_URL+bDTO.getTitle(), ObjectNode.class);
		JsonNode imgLink = objectNode.get("items").get(0).get("volumeInfo").get("imageLinks").get("thumbnail");
		JsonNode pDate = objectNode.get("items").get(0).get("volumeInfo").get("publishedDate");
		JsonNode descr = objectNode.get("items").get(0).get("volumeInfo").get("description");
		
		String pDateStr;
		if(pDate != null)
			 pDateStr = pDate.asText();
		else
			 pDateStr = "";
		
		if(pDateStr.length() > 4)
			pDateStr = pDateStr.substring(0, 3);
		
		if (pDate != null)
			bDTO.setYear(Integer.parseInt(pDateStr));
		if (descr != null)
			bDTO.setDescription(descr.asText());
		if (imgLink != null)
			bDTO.setImage(imgLink.asText());
	}

	@Override
	public void update(BookDTO book) throws InvalidDataException {
		if(book == null){
			throw new InvalidDataException();
		}
		else{
			Book b = transform(book);
			bookDao.save(b);
		}
	}

	@Override
	public void delete(Integer id) throws BookNotFoundException {
		Book b = bookDao.findOne(id);
		if(b == null){
			throw new BookNotFoundException();
		}
		else{
			b.setStatus(StatusEnum.DELETED);
			bookDao.save(b);
		}
	}

	@Override
	public List<BookDTO> getByParams(String name, String isbn, String author, Pageable pageable) throws BookNotFoundException {
		List<BookDTO> b = transform(bookDao.findParams(author, name, isbn, pageable));
		if(b.isEmpty())
			throw new BookNotFoundException();
		else{
			Iterator<BookDTO> iterator = b.iterator();
			while(iterator.hasNext()){
				getGoogleApiInfo(iterator.next());
			}
			return b;
		}
	}

	@Override
	public void modifyStatus(Book b, StatusEnum s) throws BookNotFoundException {
		if(b == null){
			throw new BookNotFoundException();
		}
		else {
			b.setStatus(s);
			bookDao.save(b);
		}
	}
	
	@Override
	public boolean checkStatus(Book b){
		if(b.getStatus() == StatusEnum.OK)
			return true;
		else
			return false;
	}

	@Override
	public List<HistoryRentedDTO> getRents(Integer id, Pageable pageable) throws BookNotFoundException, RentNotFoundException {
		Book b = bookDao.findOne(id);
		if(b == null){
			throw new BookNotFoundException();
		}
		else{
			List<RentDTO> r = rentService.getByBookId(id, pageable);
			Iterator<RentDTO> iterator = r.iterator();
			List<HistoryRentedDTO> hRented = new ArrayList<>();
			while(iterator.hasNext()){
				HistoryRentedDTO hr = new HistoryRentedDTO();
				RentDTO rdto = iterator.next();
				hr.setInit(rdto.getInitDate());
				hr.setEnd(rdto.getEndDate());
				hr.setTitle(rdto.getBook().getTitle());
				hr.setId(rdto.getBook().getId());
				hRented.add(hr);
			}
			return hRented;
		}
	}
}
