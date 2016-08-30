package com.at.library.service.bookcustom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.at.library.dto.BookDTO;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.InvalidDataException;
import com.at.library.model.Book;
import com.at.library.model.Rent;
import com.at.library.service.book.BookService;

@Service
public class BookCustomServiceImpl implements BookCustomService {

	
	@Autowired
	private BookService bookService;
	
	@Override
	public void findAll(String url) {
		RestTemplate restTemplate = new RestTemplate();
		List<Rent> rents = new ArrayList<>();
		boolean isFinished = false;
		Integer page = 0;
		do {
			ResponseEntity<List<Rent>> rentResponse =
			        restTemplate.exchange(url+"?page="+page+"&size=20",HttpMethod.GET, null, new ParameterizedTypeReference<List<Rent>>() {});
			if(rentResponse.getBody().size() == 0){
				isFinished = true;
			}
			else{
				rents.addAll(rentResponse.getBody());
				++page;
			}
		} while(!isFinished);
		
		final Iterator<Rent> iterator = rents.iterator();
		while (iterator.hasNext()) {
			boolean thrown = false;
			final Rent r = iterator.next();
			Book b = r.getBook();
			try{
				bookService.getById(b.getId());
			} catch(BookNotFoundException be) {
				thrown = true;
			}
			if(thrown){
				BookDTO bDTO = bookService.transform(b);
				try{
					bookService.create(bDTO);
				} catch(InvalidDataException id){
					id.getMessage();
				}
			}
		}
	}
}
