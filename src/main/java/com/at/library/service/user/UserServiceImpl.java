package com.at.library.service.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.at.library.controller.RentController;
import com.at.library.dao.UserDao;
import com.at.library.dto.UserDTO;
import com.at.library.dto.RentDTO;
import com.at.library.enums.UserEnum;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RentNotFoundException;
import com.at.library.exception.UserNotFoundException;
import com.at.library.model.User;
import com.at.library.service.rent.RentService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(RentController.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RentService rentService;

	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	@Scheduled(cron = "15 0/1 * * * ?")
	public void punish(){
		log.debug("Comienza el proceso de castigo de los usuarios");
	}
	
	@Override
	@Scheduled(cron = "45 0/1 * * * ?")
	public void forgive(){
		log.debug("Comprobando sanciones de usuarios");
	}

	@Override
	public List<UserDTO> findAll() {
		final Iterable<User> findAll = userDao.findAll();
		final Iterator<User> iterator = findAll.iterator();
		final List<UserDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final User u = iterator.next();
			final UserDTO uDTO = transform(u);
			res.add(uDTO);
		}
		return res;
	}

	@Override
	public UserDTO transform(User user) {
		return dozer.map(user, UserDTO.class);
	}

	@Override
	public User transform(UserDTO rent) {
		return dozer.map(rent, User.class);
	}
	
	@Override
	public List<UserDTO> transform(List<User> user) {	
		final Iterator<User> iterator = user.iterator();
		final List<UserDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final User b = iterator.next();
			final UserDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	@Override
	public UserDTO create(UserDTO user) throws InvalidDataException {
		if(user == null){
			throw new InvalidDataException();
		}
		else{
			User u = transform(user);
			u.setUserStatus(UserEnum.ALLOWED);
			return transform(userDao.save(u));
		}
	}

	@Override
	public UserDTO getByIdDTO(Integer id) throws UserNotFoundException {
		User u = userDao.findOne(id);
		if(u == null){
			throw new UserNotFoundException();
		}
		else{
			return transform(u);
		}
	}
	
	@Override
	public User getById(Integer id) throws UserNotFoundException {
		User u = userDao.findOne(id);
		if(u == null){
			throw new UserNotFoundException();
		}
		else{
			return u;
		}
	}

	@Override
	public void update(UserDTO user) throws InvalidDataException {
		if(user == null){
			throw new InvalidDataException();
		}
		else{
			User u = transform(user);
			transform(userDao.save(u));
		}
	}

	@Override
	public void delete(Integer id) throws UserNotFoundException {
		User u = userDao.findOne(id);
		if(u == null){
			throw new UserNotFoundException();
		}
		else{
			userDao.delete(id);
		}
	}

	@Override
	public List<RentDTO> getRents(Integer id) throws UserNotFoundException, RentNotFoundException {
		User u = userDao.findOne(id);
		if(u == null){
			throw new UserNotFoundException();
		}
		else{
			List<RentDTO> r = rentService.getByUserId(id);
			return r;
		}
	}

	@Override
	public List<UserDTO> getByParams(String dni, String name, String surname1, String surname2, String address) throws UserNotFoundException {
		List<UserDTO> b = transform(userDao.findByDniOrNameOrSurname1OrSurname2OrAddress(dni,name,surname1,surname2,address));
		if(b.isEmpty()){
			throw new UserNotFoundException();
		}
		else {
			return b;
		}
	}
}
