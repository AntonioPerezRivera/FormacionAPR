package com.at.library.service.rent;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.RentDao;
import com.at.library.dto.RentDTO;
import com.at.library.dto.RentPostDTO;
import com.at.library.enums.RentPunishEnum;
import com.at.library.enums.RentStatusEnum;
import com.at.library.enums.StatusEnum;
import com.at.library.enums.UserEnum;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.BookRentedException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.exception.UserBannedException;
import com.at.library.exception.UserNotFoundException;
import com.at.library.model.Book;
import com.at.library.model.Employee;
import com.at.library.model.Rent;
import com.at.library.model.User;
import com.at.library.service.book.BookService;
import com.at.library.service.employee.EmployeeService;
import com.at.library.service.user.UserService;

@Service
public class RentServiceImpl implements RentService {

	@Autowired
	private RentDao rentDao;
	
	@Autowired
	private BookService bookService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<RentDTO> findAll() {
		final Iterator<Rent> iterator = rentDao.findAll().iterator();
		final List<RentDTO> res = new ArrayList<>();
		
		while (iterator.hasNext()) {
			final Rent r = iterator.next();
			res.add(transform(r));
		}
		return res;
	}

	@Override
	public RentDTO transform(Rent rent) {
		return dozer.map(rent, RentDTO.class);
	}

	@Override
	public Rent transform(RentDTO rent) {
		return dozer.map(rent, Rent.class);
	}

	@Override
	public RentDTO create(RentPostDTO rentDto) throws UserNotFoundException, 
					BookRentedException, InvalidDataException, BookNotFoundException, UserBannedException {
		
		if(rentDto == null){
			throw new InvalidDataException();
		}
		else{
		   
			Book b = bookService.getById(rentDto.getIdLibro());
			if(b == null){
				throw new BookNotFoundException();
			}
			else{
			
				if(bookService.checkStatus(b) == true){
					
					User u = userService.getById(rentDto.getIdUser());
					
					if(u.getUserStatus() != UserEnum.ALLOWED)
						throw new UserBannedException();
					else {
						Employee e = employeeService.getById(rentDto.getIdEmployee());
							
						Rent rent = new Rent();
						
						rent.setBook(b);
						rent.setUser(u);
						rent.setEmployee(e);
						
						Date d = new Date();
						rent.setInitDate(d);
						
						// Se le suman tres dias a la fecha actual
						
						DateTime dateTime = new DateTime(d);
						rent.setEndDate(dateTime.plusDays(3).toDate());
						
						rent.setEndDate(d);
						rent.setStatus(RentStatusEnum.ACTIVE);
						rentDao.save(rent);
						bookService.modifyStatus(b, StatusEnum.RENTED);
						return transform(rent);
					}
				}
				else{
					throw new BookRentedException();
				}
			}
		}
	}

	@Override
	public void update(RentDTO rent) throws InvalidDataException {
		if(rent == null){
			throw new InvalidDataException();
		}
		else{
			Rent b = transform(rent);
			rentDao.save(b);
		}
	}
	
	@Override
	public void delete(Integer id) throws RentNotFoundException {
		Rent r = rentDao.findOne(id);
		if(r == null){
			throw new RentNotFoundException();
		}
		else{
			rentDao.delete(id);
		}
	}
	
	@Override
	public Rent getById(Integer id) throws RentNotFoundException {
		Rent b = rentDao.findOne(id);
		if(b == null){
			throw new RentNotFoundException();
		}
		else{
			return b;
		}
	}
	
	@Override
	public RentDTO getByIdDTO(Integer id) throws RentNotFoundException {
		Rent b = rentDao.findOne(id);
		if(b == null){
			throw new RentNotFoundException();
		}
		else{
			return transform(b);
		}
	}

	@Override
	public void restore(Integer book_id) throws BookNotFoundException {
		
		Book b = bookService.getById(book_id);
		if(b == null){
			throw new BookNotFoundException();
		}
		else {
			Rent r = rentDao.checkReturnNull(b.getId());
			r.setStatus(RentStatusEnum.TERMINATED);
			r.setEndDate(new Date());
			bookService.modifyStatus(b, StatusEnum.OK);
			rentDao.save(r);
		}
	}

	@Override
	public List<RentDTO> getByUserId(Integer id) throws RentNotFoundException {
		List<Rent> r = rentDao.findBookId(id);
		if(r.isEmpty()){
			throw new RentNotFoundException();
		}
		else{
			final Iterator<Rent> iterator = r.iterator();
			final List<RentDTO> res = new ArrayList<>();
			
			while (iterator.hasNext()) {
				final Rent r2 = iterator.next();
				res.add(transform(r2));
			}
			return res;
		}
	}

	@Override
	public List<RentDTO> getByBookId(Integer id) throws RentNotFoundException {
		List<Rent> r = rentDao.findBookId(id);
		if(r.isEmpty()){
			throw new RentNotFoundException();
		}
		else{
			final Iterator<Rent> iterator = r.iterator();
			final List<RentDTO> res = new ArrayList<>();
			
			while (iterator.hasNext()) {
				final Rent r2 = iterator.next();
				res.add(transform(r2));
			}
			return res;
		}
	}

	@Override
	public List<Rent> findDelayed() {
		return rentDao.delayed();
	}
	
	@Override
	public void modifyStatus(Rent u, RentPunishEnum s) throws RentNotFoundException {
		if(u == null){
			throw new RentNotFoundException();
		}
		else {
			u.setStatusPunish(s);
			rentDao.save(u);
		}
	}
	
}