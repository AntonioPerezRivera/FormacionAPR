package com.at.library.service.rent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.RentDao;
import com.at.library.dto.RentDTO;
import com.at.library.dto.RentPostDTO;
import com.at.library.enums.RentStatusEnum;
import com.at.library.enums.StatusEnum;
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
	public RentDTO create(RentPostDTO rentDto) {
		
		Book b = bookService.getById(rentDto.getIdLibro());
		
		if(bookService.checkStatus(b) == true){
			
			User u = userService.getById(rentDto.getIdUser());
			Employee e = employeeService.getById(rentDto.getIdEmployee());
				
			Rent rent = new Rent();
			
			rent.setBook(b);
			rent.setUser(u);
			rent.setEmployee(e);
			
			Date d = new Date();
			rent.setInitDate(d);
			
			// Se le suman tres dias a la fecha actual
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, 3);
			d = cal.getTime();
			
			rent.setEndDate(d);
			rent.setStatus(RentStatusEnum.ACTIVE);
			rentDao.save(rent);
			bookService.modifyStatus(b, StatusEnum.DISABLE);
			return transform(rent);
		}
		
		else{
			return new RentDTO();
		}
	}

	@Override
	public void update(RentDTO rent) {
		Rent b = transform(rent);
		rentDao.save(b);		
	}
	
	@Override
	public void delete(Integer id) {
		rentDao.delete(id);
	}
	
	@Override
	public Rent getById(Integer id) {
		Rent b = rentDao.findOne(id);
		return b;
	}
	
	@Override
	public RentDTO getByIdDTO(Integer id){
		Rent b = rentDao.findOne(id);
		return transform(b);
	}

}